package com.blogApp.Blog_application_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogApp.Blog_application_project.repositories.UserRepo;

@SpringBootTest
class BlogApplicationProjectApplicationTests {
	
	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String Classname = this.userRepo.getClass().getName();
		String packageName = this.userRepo.getClass().getPackageName();
		System.out.println(Classname);
		System.out.println(packageName);
		
	}

}
