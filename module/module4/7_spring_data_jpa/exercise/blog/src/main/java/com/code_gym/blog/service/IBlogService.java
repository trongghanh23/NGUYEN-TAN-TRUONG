package com.code_gym.blog.service;


import com.code_gym.blog.dto.IBlogDto;
import com.code_gym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<IBlogDto> searchByTitle();
}
