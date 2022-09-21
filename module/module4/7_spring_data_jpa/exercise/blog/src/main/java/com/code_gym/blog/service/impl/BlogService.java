package com.code_gym.blog.service.impl;

import com.code_gym.blog.dto.IBlogDto;
import com.code_gym.blog.model.Blog;
import com.code_gym.blog.repository.IBlogRepository;
import com.code_gym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<IBlogDto> searchByTitle() {
        return iBlogRepository.searchByTitle();
    }


}
