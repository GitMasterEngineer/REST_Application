package com.blogApp.Blog_application_project.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	
	private String title;

	//@NotBlank(message = "Content can't be blank")
	private String content;
	
	private String imageName;
	@NotNull
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	

}
