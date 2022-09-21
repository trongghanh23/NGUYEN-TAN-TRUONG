package com.example.demo.service;

import com.example.demo.model.Blog;
import java.util.List;

public interface IBlogService {

    List<Blog> findAllSearchAndPaging(String name);

//    Page<Blogger> getAllBlog(String searchName, Pageable pageable);
}
