package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuariosPdfs;

public interface UsuarioPdfService {

	public List<UsuariosPdfs> listAllUsuariosPdfs();

	public UsuariosPdfs saveUsuariosPdfs(UsuariosPdfs usuario_pdf);

	public UsuariosPdfs usuariosPdfsById(Long id);

	public UsuariosPdfs updateUsuariosPdfs(UsuariosPdfs usuario_pdf);

	public void deleteUsuariosPdfs(Long id);
}
