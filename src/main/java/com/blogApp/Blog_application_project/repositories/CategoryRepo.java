package com.blogApp.Blog_application_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogApp.Blog_application_project.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
