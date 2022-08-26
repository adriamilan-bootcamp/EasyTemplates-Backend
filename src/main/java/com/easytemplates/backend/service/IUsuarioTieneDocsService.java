package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuarioTieneDocs;

// Interface skeleton for the UsuarioTieneDocs Service
public interface IUsuarioTieneDocsService {

	/**
	 * Lists all the UsuarioTieneDocs
	 * 
	 * @return the UsuarioTieneDocs
	 */
	public List<UsuarioTieneDocs> listAllUsuarioTieneDocs();
	
	/**
	 * Saves the UsuarioTieneDocs
	 * 
	 * @param u
	 * @return the UsuarioTieneDocs
	 */
	public UsuarioTieneDocs saveUsuarioTieneDocs(UsuarioTieneDocs u);
	
	/**
	 * Returns a UsuarioTieneDocs
	 * 
	 * @param id
	 * @return the UsuarioTieneDocs
	 */
	public UsuarioTieneDocs usuarioTieneDocsById(Long id);
	
	/**
	 * Updates the UsuarioTieneDocs
	 * 
	 * @param u
	 * @return the UsuarioTieneDocs
	 */
	public UsuarioTieneDocs updateUsuarioTieneDocs(UsuarioTieneDocs u);
	
	/**
	 * Deletes a UsuarioTieneDocs
	 * 
	 * @param id
	 */
	public void deleteUsuarioTieneDocs(Long id);
}
