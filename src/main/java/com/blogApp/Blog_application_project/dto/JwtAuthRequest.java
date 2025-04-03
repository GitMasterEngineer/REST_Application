package com.blogApp.Blog_application_project.dto;

import lombok.Data;

@Data
public class JwtAuthRequest {

		private String username;
		private String password;
}
