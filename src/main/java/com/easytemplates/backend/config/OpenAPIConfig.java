package com.easytemplates.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("EasyTemplates API")
	              .description("Public and Private EasyTemplates API Docs!")
	              .version("v0.1")
	              .license(new License().name("Apache 2.0").url("https://github.com/adriamilan-bootcamp/EasyTemplates-Backend")))
	              .externalDocs(new ExternalDocumentation()
	              .description("EasyTemplates API Documentation")
	              .url("https://github.com/adriamilan-bootcamp/EasyTemplates-Backend"));
	  }

}