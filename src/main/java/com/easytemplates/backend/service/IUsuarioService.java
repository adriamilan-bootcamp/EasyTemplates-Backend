package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Usuarios;


public interface IUsuarioService{
	/***
	 * 
	 * @return all usuarios
	 */
	public List<Usuarios> listAllUsuarios();
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	
	public Usuarios saveUsuario(Usuarios usuario);
	
	/***
	 * 
	 * @param id
	 * @return usuario
	 */
	public Usuarios usuarioById(Long id);
	
	

	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuarios updateUsuario(Usuarios usuario);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteUsuario(Long id);
}