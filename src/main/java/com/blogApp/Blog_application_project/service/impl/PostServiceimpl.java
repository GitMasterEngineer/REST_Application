package com.blogApp.Blog_application_project.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogApp.Blog_application_project.dto.PostDto;
import com.blogApp.Blog_application_project.entity.Category;
import com.blogApp.Blog_application_project.entity.Post;
import com.blogApp.Blog_application_project.entity.User;
import com.blogApp.Blog_application_project.exceptions.ResourceNotFoundException;
import com.blogApp.Blog_application_project.repositories.CategoryRepo;
import com.blogApp.Blog_application_project.repositories.PostRepo;
import com.blogApp.Blog_application_project.repositories.UserRepo;
import com.blogApp.Blog_application_project.service.PostService;

@Service
public class PostServiceimpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postdto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));

		Post post = this.modelMapper.map(postdto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newpost = this.postRepo.save(post);
		return this.modelMapper.map(newpost, PostDto.class);

	}

	@Override
	public PostDto updatePost(PostDto postdto, Integer postId) {
		Post posts = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
		posts.setTitle(postdto.getTitle());
		posts.setContent(postdto.getContent());
		posts.setImageName(postdto.getImageName());
		Post savedupdated = this.postRepo.save(posts);
		return this.modelMapper.map(savedupdated, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post posts = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
		this.postRepo.delete(posts);
	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost = this.postRepo.findAll(p);
		List<Post> allposts = pagePost.getContent();

		// List<Post> posts = this.postRepo.findAll();
		return allposts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> PostDtos = posts.stream().map((users) -> this.modelMapper.map(users, PostDto.class))
				.collect(Collectors.toList());
		return PostDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = this.postRepo.findByTitleContainingIgnoreCase(keyword);

		return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

}
