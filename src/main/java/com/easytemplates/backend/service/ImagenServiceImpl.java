package com.easytemplates.backend.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.easytemplates.backend.dao.IImagenDAO;
import com.easytemplates.backend.dto.Imagen;
@Service
public class ImagenServiceImpl implements IImagenService {
	
	@Autowired
	IImagenDAO imagenDAO;
	
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	@Override
	public List<Imagen> listImagenes() {
		return imagenDAO.findAll();
	}

	@Override
	public Imagen imagenXID(Long id) {
		return imagenDAO.findById(id).get();
	}

	@Override
	public String deleteImagen(Long id) {
		imagenDAO.deleteById(id);
		return "Imagen " + id + " eliminada";
	}

	@Override
	public void uploadFile(MultipartFile file) {
		File mainFile = new File(file.getOriginalFilename());
		try(FileOutputStream stream = new FileOutputStream(mainFile)) {
			stream.write(file.getBytes());
			String newFileName = System.currentTimeMillis() + "_" + mainFile.getName();
			System.out.println("Subiendo archivo con el nombre " + newFileName);
			PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
			amazonS3.putObject(request);

			// Image Constructor 
			Imagen imagen = new Imagen();
			imagen.setSrc(amazonS3.getUrl(bucketName, newFileName).toString());
			imagenDAO.save(imagen);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
