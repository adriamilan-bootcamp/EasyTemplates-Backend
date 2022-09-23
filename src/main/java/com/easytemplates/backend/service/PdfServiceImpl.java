package com.easytemplates.backend.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.easytemplates.backend.dao.IPdfDAO;
import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Pdfs;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.dto.UsuariosPdfs;
import com.easytemplates.backend.security.SecurityLogging;

@Service
// Implementation of the PdfService interface
public class PdfServiceImpl implements IPdfService {
	
	@Autowired
	IPlantillaDAO plantillaDAO;

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	// The DAO Handler for the operations
	@Autowired
	IPdfDAO pdfDAO;

	@Autowired
	IUsuarioDAO userDao;
	
	@Autowired
	UsuarioPdfServiceImpl pdfuserSvc;
	
	/**
	 * Lists all the Pdf's
	 * 
	 * @return the Pdf's
	 */
	@Override
	public List<Pdfs> listAllPdfs() {
		return pdfDAO.findAll();
	}

	/**
	 * Saves the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	@Override
	public Pdfs savePdf(Pdfs p) {
		return pdfDAO.save(p);
	}

	/**
	 * Returns a Pdf
	 * 
	 * @param id
	 * @return the Pdf
	 */
	@Override
	public Pdfs pdfById(Long id) {
		return pdfDAO.findById(id).get();
	}

	/**
	 * Updates the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	@Override
	public Pdfs updatePdf(Pdfs p) {
		return pdfDAO.save(p);
	}

	/**
	 * Deletes a Pdf
	 * 
	 * @param id
	 */
	@Override
	public void deletePdf(Long id) {
		pdfDAO.deleteById(id);
	}

	@Override
	public void uploadFile(MultipartFile file, String title) throws Exception {
		File mainFile = new File(file.getOriginalFilename());
		try(FileOutputStream stream = new FileOutputStream(mainFile)) {
			stream.write(file.getBytes());
			String newFileName = System.currentTimeMillis() + "_" + mainFile.getName();
			SecurityLogging.logMsg("PDF-S3", "Uploading " + mainFile.getName());
			
			PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
			amazonS3.putObject(request);

			// Image Constructor 
			Pdfs pdf = new Pdfs();

			pdf.setSrc(amazonS3.getUrl(bucketName, newFileName).toString());
			pdf.setFechaCreacion(LocalDateTime.now());
			pdf.setTitulo(title);
			pdfDAO.save(pdf);
			
			Usuarios userReq = userDao.findByEmail(((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
			
			UsuariosPdfs userPdf = new UsuariosPdfs();
			
			userPdf.setUsuarios(userReq);
			userPdf.setPdfs(pdf);
			
			pdfuserSvc.saveUsuariosPdfs(userPdf);
			
		} catch (IOException e) {
			throw new IOException(e);
		} 
	}
	
	@Async
	public byte[] downloadFile(String keyName) {
		byte[] content = null;
		
        try {
        	
            S3Object s3object = amazonS3.getObject(new GetObjectRequest(bucketName, keyName));

            final S3ObjectInputStream stream = s3object.getObjectContent();
            
            try {
                content = IOUtils.toByteArray(stream);
                SecurityLogging.logMsg("PDF-S3", keyName + " downloaded successfully!");
                s3object.close();
            } catch(final IOException ex) {
            	System.out.println("IOException: " + ex.getMessage());
            }
        } catch (AmazonServiceException serviceException) {
        	System.out.println("AmazonServiceException Message:    " + serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
        	System.out.println("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }

        return content;
    }
}
