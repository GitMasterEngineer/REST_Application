package com.blogApp.Blog_application_project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
		
		private String message;
		private boolean success;
		
		public ApiResponse(String message, boolean success) {
			super();
			this.message = message;
			this.success = success;
		}
		
		
	
}
