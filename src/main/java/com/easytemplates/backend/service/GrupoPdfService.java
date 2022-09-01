package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.GruposPdfs;

public interface GrupoPdfService {
	public List<GruposPdfs> listAllGruposPdfs();

	public GruposPdfs saveGruposPdfs(GruposPdfs grupo_pdf);

	public GruposPdfs gruposPdfsById(Long id);

	public GruposPdfs updateGruposPdfs(GruposPdfs grupopdf);

	public void deleteGruposPdfs(Long id);
}
