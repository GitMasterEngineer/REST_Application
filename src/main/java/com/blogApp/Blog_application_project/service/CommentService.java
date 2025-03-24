package com.blogApp.Blog_application_project.service;

import com.blogApp.Blog_application_project.dto.CommentDto;

public interface CommentService {

		public CommentDto createComment(CommentDto commentDto, Integer postId);
		
		void deleteComment(Integer commentDto);
}
