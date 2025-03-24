package com.blogApp.Blog_application_project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogApp.Blog_application_project.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

		Optional<User> findByEmail(String email);
}
