package com.easytemplates.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.service.GrupoTieneDocsServiceImpl;

@RestController
@RequestMapping("/api")
public class GrupoTieneDocsController {

	@Autowired
	GrupoTieneDocsServiceImpl gtdCtl;
}
