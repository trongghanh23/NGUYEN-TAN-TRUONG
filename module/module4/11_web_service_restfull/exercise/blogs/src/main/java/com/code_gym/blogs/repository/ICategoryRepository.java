package com.code_gym.blogs.repository;

import com.code_gym.blogs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
