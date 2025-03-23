package com.blogApp.Blog_application_project.service;

import java.util.List;

import com.blogApp.Blog_application_project.dto.CategoryDto;

public interface CategoryService {

		public CategoryDto createCategory(CategoryDto categoryDto);
		
		public CategoryDto updaCategoryDto(CategoryDto categoryDto, Integer categoryId);
		
		void daleteCategory(Integer categoryId);
		
		CategoryDto getCategory(Integer categoryId);
		
		List<CategoryDto> getCategories();

}
