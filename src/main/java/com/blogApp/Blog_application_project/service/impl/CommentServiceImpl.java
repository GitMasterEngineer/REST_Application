package com.blogApp.Blog_application_project.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.Blog_application_project.dto.CommentDto;
import com.blogApp.Blog_application_project.entity.Comment;
import com.blogApp.Blog_application_project.entity.Post;
import com.blogApp.Blog_application_project.exceptions.ResourceNotFoundException;
import com.blogApp.Blog_application_project.repositories.CommentRepo;
import com.blogApp.Blog_application_project.repositories.PostRepo;
import com.blogApp.Blog_application_project.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savecomment = this.commentRepo.save(comment);
		return this.modelMapper.map(savecomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment=this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "commentId",commentId));
		this.commentRepo.delete(comment);
	}

}
