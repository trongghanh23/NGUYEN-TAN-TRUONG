package com.code_gym.blogs.service.impl;


import com.code_gym.blogs.model.Blog;
import com.code_gym.blogs.repository.IBlogRepository;
import com.code_gym.blogs.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }


    @Override
    public Blog getId(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> blogOfCategory(Integer id) {
        return iBlogRepository.blogOfCategory(id);
    }


}
