package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.GrupoTieneDocs;

public interface IGrupoTieneDocsService {

	/**
	 * Returns all GrupoTieneDocs
	 * 
	 * @return the list
	 */
	public List<GrupoTieneDocs> listAllGrupoTieneDocs();
	
	/**
	 * Saves the GrupoTieneDocs
	 * 
	 * @param g
	 * @return the GrupoTieneDocs
	 */
	public GrupoTieneDocs saveGrupoTieneDocs(GrupoTieneDocs g);
	
	/**
	 * Returns a GrupoTieneDocs
	 * 
	 * @param id
	 * @return the GrupoTieneDocs
	 */
	public GrupoTieneDocs grupoTieneDocsById(Long id);
	
	/**
	 * Updates the GrupoTieneDocs
	 * 
	 * @param g
	 * @return the GrupoTieneDocs
	 */
	public GrupoTieneDocs updateGrupoTieneDocs(GrupoTieneDocs g);
	
	/**
	 * Deletes a GrupoTieneDocs
	 * 
	 * @param id
	 */
	public void deleteGrupoTieneDocs(Long id);
}
