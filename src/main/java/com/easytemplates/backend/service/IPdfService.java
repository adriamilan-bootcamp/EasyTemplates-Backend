package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dto.Pdfs;

// Interface skeleton for the Pdf Service
public interface IPdfService {

	/**
	 * Lists all the Pdf's
	 * 
	 * @return the Pdf's
	 */
	public List<Pdfs> listAllPdfs();
	
	/**
	 * Saves the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	public Pdfs savePdf(Pdfs p);
	
	/**
	 * Returns a Pdf
	 * 
	 * @param id
	 * @return the Pdf
	 */
	public Pdfs pdfById(Long id);
	
	/**
	 * Updates the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	public Pdfs updatePdf(Pdfs p);
	
	/**
	 * Deletes a Pdf
	 * 
	 * @param id
	 */
	public void deletePdf(Long id);
	
	public void uploadFile(MultipartFile file, String title) throws Exception;
}
