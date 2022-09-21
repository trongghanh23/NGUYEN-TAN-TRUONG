package com.code_gym.blog.service;

import com.code_gym.blog.dto.IBlogDto;
import com.code_gym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllSearchAndPaging(String nameBlog, Pageable pageable);

    void save(Blog blog);

    Blog getId(Integer id);

    void delete(Integer id);
    List<IBlogDto> searchByTitle(String name, Pageable pageable);
}
