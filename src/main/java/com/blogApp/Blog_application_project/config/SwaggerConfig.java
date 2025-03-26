package com.blogApp.Blog_application_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.lang.Collections;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();

	}
	
	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("Blogging application : Backend Course","This course develope bu anup Don", "1.0","Terms and service"
				,new Contact("anup","https://learncodewithdurgesh.com","anuppochchhi24@gmail.com"),"Lincense of APIs", "API  lincense URL",Collections.emptyList());
	}

	
}
