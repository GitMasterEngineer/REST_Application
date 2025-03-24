package com.blogApp.Blog_application_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.Blog_application_project.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

		
}
