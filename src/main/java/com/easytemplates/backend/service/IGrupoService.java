package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Grupos;


public interface IGrupoService{
	
	/***
	 * 
	 * @return all grupos
	 */
	public List<Grupos> listAllGrupos();
	
	/***
	 * 
	 * @param grupo
	 * @return
	 */
	
	public Grupos saveGrupo(Grupos grupo);
	
	/***
	 * 
	 * @param id
	 * @return usuario
	 */
	public Grupos gruposById(Long id);
	
	/***
	 * 
	 * @param grupos
	 * @return
	 */
	public Grupos updateGrupo(Grupos grupo);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteGrupo(Long id);
}