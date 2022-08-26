package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuarioPerteneceGrupos;



public interface IUsuarioPerteneceGruposService{
	
	/***
	 * 
	 * @return all usuarioPerenecegrupos
	 */
	public List<UsuarioPerteneceGrupos> listAllUsuarioPerteneceGrupos();
	
	
	/***
	 * 
	 * @param usuarioPerteneceGrupos
	 * @return
	 */
	public UsuarioPerteneceGrupos saveUsuarioPerteneceGrupos(UsuarioPerteneceGrupos usuarioPerteneceGrupos);
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	public UsuarioPerteneceGrupos usuarioPerteneceGruposById(Long id);
	
	
	/***
	 * 
	 * @param usuarioPerteneceGrupo
	 * @return
	 */
	public UsuarioPerteneceGrupos updateUsuarioPerteneceGrupos(UsuarioPerteneceGrupos usuarioPerteneceGrupo);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteUsuarioPerteneceGrupos(Long id);
}
