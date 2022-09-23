package com.easytemplates.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
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
import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dto.Plantillas;
@Service
public class PlantillaServiceImpl implements IPlantillaService {

	@Autowired
	IPlantillaDAO plantillaDAO;

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	@Override
	public List<Plantillas> listPlantillas() {
		return plantillaDAO.findAll();
	}

	@Override
	public Plantillas plantillaXID(Long id) {
		return plantillaDAO.findById(id).get();
	}

	@Override
	public Plantillas savePlantilla(Plantillas plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public Plantillas updatePlantila(Plantillas plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public String deletePlantilla(Long id) {
		plantillaDAO.deleteById(id);
		return "Plantilla " + id + " eliminada";
	}

	@Override
	public void uploadFile(MultipartFile file, String title) throws Exception {
		File mainFile = new File(file.getOriginalFilename());
		try(FileOutputStream stream = new FileOutputStream(mainFile)) {
			stream.write(file.getBytes());
			String newFileName = System.currentTimeMillis() + "_" + mainFile.getName();
			System.out.println("Subiendo archivo con el nombre " + newFileName);
			PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
			amazonS3.putObject(request);

			// Image Constructor 
			Plantillas plantilla = new Plantillas();
			LocalDateTime fechaCreacion;
			
			plantilla.setSrc(amazonS3.getUrl(bucketName, newFileName).toString());
			plantilla.setFechaCreacion(LocalDateTime.now());
			plantilla.setTitulo(title);
			plantillaDAO.save(plantilla);
		} catch (IOException e) {
			throw new IOException(e);
		} 
	}
	
	@Async
	public ByteArrayOutputStream downloadFile(String keyName) {
        try {
        	byte[] content = null;
        	
            S3Object s3object = amazonS3.getObject(new GetObjectRequest(bucketName, keyName));

            final S3ObjectInputStream stream = s3object.getObjectContent();
            
            try {
                content = IOUtils.toByteArray(stream);
                System.out.println("File downloaded successfully.");
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

        return null;
    }

}
