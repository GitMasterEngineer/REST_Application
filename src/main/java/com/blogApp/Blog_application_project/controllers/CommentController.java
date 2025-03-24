package com.blogApp.Blog_application_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.Blog_application_project.dto.ApiResponse;
import com.blogApp.Blog_application_project.dto.CommentDto;
import com.blogApp.Blog_application_project.entity.Comment;
import com.blogApp.Blog_application_project.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	// post comment
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {

		CommentDto comment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(comment, HttpStatus.CREATED);
	}

	// delete comment
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deteleComment(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("this is succesfully deleted", true), HttpStatus.OK);
	}

}
