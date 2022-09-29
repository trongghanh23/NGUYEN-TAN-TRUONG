package com.code_gym.blogs.controller;

import com.code_gym.blogs.model.Blog;
import com.code_gym.blogs.model.Category;
import com.code_gym.blogs.service.IBlogService;
import com.code_gym.blogs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RestBlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @GetMapping("/listBlog")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);

    }

    @GetMapping("/blogOfCategory/{id}")
    public ResponseEntity<List<Blog>> showBlogOfCategory(@PathVariable Integer id) {
        List<Blog> blogList = iBlogService.blogOfCategory(id);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detailBlog/{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable Integer id) {
        Blog blogList = iBlogService.getId(id);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);

    }

    @PostMapping("/search")
    public ResponseEntity<List<Blog>> searchBlog(@RequestParam(defaultValue = "") String name) {
        List<Blog> blogList = iBlogService.findAllSearch(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


}
