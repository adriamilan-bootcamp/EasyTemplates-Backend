package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IPdfDAO;
import com.easytemplates.backend.dto.Pdfs;

@Service
// Implementation of the PdfService interface
public class PdfServiceImpl implements IPdfService {
	
	// The DAO Handler for the operations
	@Autowired
	IPdfDAO pdfDAO;

	/**
	 * Lists all the Pdf's
	 * 
	 * @return the Pdf's
	 */
	@Override
	public List<Pdfs> listAllPdfs() {
		return pdfDAO.findAll();
	}

	/**
	 * Saves the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	@Override
	public Pdfs savePdf(Pdfs p) {
		return pdfDAO.save(p);
	}

	/**
	 * Returns a Pdf
	 * 
	 * @param id
	 * @return the Pdf
	 */
	@Override
	public Pdfs pdfById(Long id) {
		return pdfDAO.findById(id).get();
	}

	/**
	 * Updates the Pdf
	 * 
	 * @param p
	 * @return the Pdf
	 */
	@Override
	public Pdfs updatePdf(Pdfs p) {
		return pdfDAO.save(p);
	}

	/**
	 * Deletes a Pdf
	 * 
	 * @param id
	 */
	@Override
	public void deletePdf(Long id) {
		pdfDAO.deleteById(id);
	}
}
