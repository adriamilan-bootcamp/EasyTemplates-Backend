package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioPlantillaDAO;
import com.easytemplates.backend.dto.UsuariosPlantillas;
@Service
public class UsuarioPlantillaServiceImpl implements UsuarioPlantillaService{

	@Autowired
	IUsuarioPlantillaDAO iUsuarioPlantillaDAO;
	@Override
	public List<UsuariosPlantillas> listAllUsuariosPlantillas() {
		// TODO Auto-generated method stub
		return iUsuarioPlantillaDAO.findAll();
	}

	@Override
	public UsuariosPlantillas saveUsuariosPlantillas(UsuariosPlantillas usuario_plantillas) {
		// TODO Auto-generated method stub
		return iUsuarioPlantillaDAO.save(usuario_plantillas);
	}

	@Override
	public UsuariosPlantillas usuariosPlantillasById(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioPlantillaDAO.findById(id).get();
	}

	@Override
	public UsuariosPlantillas updateUsuariosPlantillas(UsuariosPlantillas usuario_plantilla) {
		// TODO Auto-generated method stub
		return iUsuarioPlantillaDAO.save(usuario_plantilla);
	}

	@Override
	public void deleteUsuariosPlantillas(Long id) {
		iUsuarioPlantillaDAO.deleteById(id);		
	}

}
