package com.easytemplates.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EasyTemplatesController {

	@GetMapping("/")
	ResponseEntity<String> welcome() {
		return ResponseEntity.ok()
			      .body("Greetings from EasyTemplates!");
	}
}
