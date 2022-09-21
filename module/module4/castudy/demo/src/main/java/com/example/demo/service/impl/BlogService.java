package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAllSearchAndPaging(String name) {
        return iBlogRepository.searchStudentWithName(name);
    }

//    @Override
//    public Page<Blogger> getAllBlog(String searchName , Pageable pageable) {
//        return this.blogRepository.getAllBlog("%" + searchName + "%" ,pageable);
//    }
}
