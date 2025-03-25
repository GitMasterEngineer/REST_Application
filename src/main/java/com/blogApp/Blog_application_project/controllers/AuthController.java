package com.blogApp.Blog_application_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.Blog_application_project.blog.security.JwtTokenHelper;
import com.blogApp.Blog_application_project.dto.JwtAuthRequest;
import com.blogApp.Blog_application_project.dto.JwtAuthResponse;
import com.blogApp.Blog_application_project.dto.UserDto;
import com.blogApp.Blog_application_project.exceptions.ApiException;
import com.blogApp.Blog_application_project.service.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		this.authenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);

//		try {
//			this.authenticate(request.getUsername(), request.getPassword());
//
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
//
//			String token = this.jwtTokenHelper.generateToken(userDetails);
//			JwtAuthResponse response = new JwtAuthResponse();
//			response.setToken(token);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} catch (BadCredentialsException e) {
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		}

	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
		this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException ex)
		{
			System.out.println("Invlaid Details !!");
			throw new ApiException("Username and password Invalid !!");
		}

	}
	
	//register new user API
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto)
	{
		UserDto registerNewUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registerNewUser,HttpStatus.CREATED);
	}
}
