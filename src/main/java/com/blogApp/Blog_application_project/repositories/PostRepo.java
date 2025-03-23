package com.blogApp.Blog_application_project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.Blog_application_project.entity.Category;
import com.blogApp.Blog_application_project.entity.Post;
import com.blogApp.Blog_application_project.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContainingIgnoreCase(String keyword);

}
