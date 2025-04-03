package com.blogApp.Blog_application_project.service;

import java.util.List;

import com.blogApp.Blog_application_project.dto.UserDto;

public interface UserService {
	
		UserDto registerNewUser(UserDto userDto);

		UserDto createUser (UserDto userDto);
		
		UserDto updateUser(UserDto userDto, Integer userId);
		
		UserDto getUserById(Integer userId);
		
		List<UserDto> getAllUsers();
		
		void deleteUser(Integer userId);
}
