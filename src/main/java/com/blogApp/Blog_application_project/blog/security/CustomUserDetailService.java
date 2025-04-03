package com.blogApp.Blog_application_project.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogApp.Blog_application_project.entity.User;
import com.blogApp.Blog_application_project.exceptions.ResourceNotFoundException;
import com.blogApp.Blog_application_project.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	// User details user load karega spring security la
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
		//System.out.println("Print username:"+username);
		
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email:"+ username,0));

		return user;
		
	}

}
