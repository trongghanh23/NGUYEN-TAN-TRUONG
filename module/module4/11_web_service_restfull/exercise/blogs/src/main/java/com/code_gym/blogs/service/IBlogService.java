package com.code_gym.blogs.service;


import com.code_gym.blogs.model.Blog;

import java.util.List;


public interface IBlogService {
    List<Blog> findAll();

    Blog getId(Integer id);

    List<Blog> blogOfCategory(Integer id);
}
