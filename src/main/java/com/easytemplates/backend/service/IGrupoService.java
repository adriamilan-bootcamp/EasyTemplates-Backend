package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Grupo;


public interface IGrupoService{
	
	/***
	 * 
	 * @return all grupos
	 */
	public List<Grupo> listAllGrupos();
	
	/***
	 * 
	 * @param grupo
	 * @return
	 */
	
	public Grupo saveGrupo(Grupo grupo);
	
	/***
	 * 
	 * @param id
	 * @return usuario
	 */
	public Grupo gruposById(Long id);
	
	/***
	 * 
	 * @param grupos
	 * @return
	 */
	public Grupo updateGrupo(Grupo grupo);
	
	/***
	 * 
	 * @param id
	 */
	public void deleteGrupo(Long id);
}