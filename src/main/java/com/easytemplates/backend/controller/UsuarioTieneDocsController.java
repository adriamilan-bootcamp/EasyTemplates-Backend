package com.easytemplates.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.service.PdfServiceImpl;
import com.easytemplates.backend.service.UsuarioTieneDocsServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioTieneDocsController {

	@Autowired
	UsuarioTieneDocsServiceImpl utdCtl;
}