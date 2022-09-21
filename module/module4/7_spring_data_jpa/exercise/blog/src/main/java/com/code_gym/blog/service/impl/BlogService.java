package com.code_gym.blog.service.impl;

import com.code_gym.blog.dto.IBlogDto;
import com.code_gym.blog.model.Blog;
import com.code_gym.blog.repository.IBlogRepository;
import com.code_gym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllSearchAndPaging(String nameBlog, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(nameBlog,pageable);
    }

    @Override
    public void save(Blog customer) {
        iBlogRepository.save(customer);
    }

    @Override
    public Blog getId(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<IBlogDto> searchByTitle(String name, Pageable pageable) {
        return iBlogRepository.searchByTitle();
    }
}
