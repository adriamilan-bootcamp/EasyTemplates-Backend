package com.easytemplates.backend.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.easytemplates.backend.dao.IImagenDAO;
import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Imagenes;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.dto.UsuariosImagenes;
import com.easytemplates.backend.security.SecurityLogging;

@Service
public class ImagenServiceImpl implements IImagenService {
	
	@Autowired
	IImagenDAO imagenDAO;

	@Autowired
	IUsuarioDAO userDao;
	
	@Autowired
	UsuarioImagenServiceImpl imguserSvc;
	
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	@Override
	public List<Imagenes> listImagenes() {
		return imagenDAO.findAll();
	}

	@Override
	public Imagenes imagenXID(Long id) {
		return imagenDAO.findById(id).get();
	}

	@Override
	public String deleteImagen(Long id) {
		imagenDAO.deleteById(id);
		return "Imagen " + id + " eliminada";
	}

	@Override
	public String uploadFile(MultipartFile file) throws Exception {
		File mainFile = new File(file.getOriginalFilename());
		try(FileOutputStream stream = new FileOutputStream(mainFile)) {
			stream.write(file.getBytes());
			String newFileName = System.currentTimeMillis() + "_" + mainFile.getName();
			SecurityLogging.logMsg("IMAGES-S3", "Uploading " + mainFile.getName());
			PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, mainFile);
			amazonS3.putObject(request);


			Usuarios userReq = userDao.findByEmail(((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
			
			
			// Image Constructor 
			Imagenes imagen = new Imagenes();
			imagen.setSrc(amazonS3.getUrl(bucketName, newFileName).toString());
			imagenDAO.save(imagen);
			
			UsuariosImagenes userImg = new UsuariosImagenes();
			
			userImg.setUsuario(userReq);
			userImg.setImagenes(imagen);
			
			imguserSvc.saveUsuariosImagenes(userImg);
			
			return amazonS3.getUrl(bucketName, newFileName).toString();
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
	
} 
