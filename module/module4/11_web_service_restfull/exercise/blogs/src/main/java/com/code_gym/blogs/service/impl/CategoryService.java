package com.code_gym.blogs.service.impl;


import com.code_gym.blogs.model.Category;
import com.code_gym.blogs.repository.ICategoryRepository;
import com.code_gym.blogs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }


}
