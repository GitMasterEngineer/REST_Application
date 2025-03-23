package com.blogApp.Blog_application_project.service;

import java.util.List;

import com.blogApp.Blog_application_project.dto.PostDto;
import com.blogApp.Blog_application_project.entity.Post;

public interface PostService {

	// create
	PostDto createPost(PostDto postdto,Integer userId,Integer categoryId);

	// update
	PostDto updatePost(PostDto postdto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get all posts
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

	// get Single Post
	PostDto getPostById(Integer postId);

	// get all post by category

	List<PostDto> getPostByCategory(Integer categoryId);

	// get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<PostDto> searchPosts(String keyword);

}
