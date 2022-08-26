package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Pdf;

// Interface skeleton for the Pdf Service
public interface IPdfService {

	/**
	 * Lists all the Pdf's
	 * 
	 * @return the Pdf's
	 */
	public List<Pdf> listAllPdfs();
	
	/**
	 * Saves the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	public Pdf savePdf(Pdf p);
	
	/**
	 * Returns a Pdf
	 * 
	 * @param id
	 * @return the Pdf
	 */
	public Pdf pdfById(Long id);
	
	/**
	 * Updates the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	public Pdf updatePdf(Pdf p);
	
	/**
	 * Deletes a Pdf
	 * 
	 * @param id
	 */
	public void deletePdf(Long id);
}
