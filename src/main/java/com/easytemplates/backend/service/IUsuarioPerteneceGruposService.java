package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;



public interface IUsuarioPerteneceGruposService{
	
	/***
	 * 
	 * @return all usuarioPerenecegrupos
	 */
	public List<UsuariosPertenecenGrupos> listAllUsuarioPerteneceGrupos();
	
	
	/***
	 * 
	 * @param usuarioPerteneceGrupos
	 * @return
	 */
	public UsuariosPertenecenGrupos saveUsuarioPerteneceGrupos(UsuariosPertenecenGrupos usuarioPerteneceGrupos);
	
	/***
	 * 
	 * @param id
	 * @return
	 */
	public UsuariosPertenecenGrupos usuarioPerteneceGruposById(Long id);
	
	
	/***
	 * 
	 * @param usuarioPerteneceGrupo
	 * @return
	 */
	public UsuariosPertenecenGrupos updateUsuarioPerteneceGrupos(UsuariosPertenecenGrupos usuarioPerteneceGrupo);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteUsuarioPerteneceGrupos(Long id);
}
