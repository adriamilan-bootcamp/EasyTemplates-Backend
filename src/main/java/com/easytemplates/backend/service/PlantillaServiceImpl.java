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
	public void uploadFile(MultipartFile file) throws Exception {
		File mainFile = new File(file.getOriginalFilename());
		try(FileOutputStream stream = new FileOutputStream(mainFile)) {
			stream.write(file.getBytes());
			String newFileName = System.currentTimeMillis() + "_" + mainFile.getName();
			System.out.println("Subiendo archivo con el nombre " + newFileName);
			PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
			amazonS3.putObject(request);

			// Image Constructor 
			Plantillas plantilla = new Plantillas();
			plantilla.setSrc(amazonS3.getUrl(bucketName, newFileName).toString());
			plantillaDAO.save(plantilla);
		} catch (IOException e) {
			throw new IOException(e);
		} 
	}
}
