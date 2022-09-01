package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Usuario;


public interface IUsuarioService{
	/***
	 * 
	 * @return all usuarios
	 */
	public List<Usuario> listAllUsuarios();
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	
	public Usuario saveUsuario(Usuario usuario);
	

	public Usuario usuarioByUsername (String username);
	
	/***
	 * 
	 * @param id
	 * @return usuario
	 */
	public Usuario usuarioById(Long id);
	
	/***
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario updateUsuario(Usuario usuario);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteUsuario(Long id);
}