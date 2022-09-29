package com.code_gym.blogs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private Integer id;
    private String categoryName;
    private String birth;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Blog> blogList;

    public Category() {
    }

    public Category(Integer id, String categoryName, String birth, List<Blog> blogList) {
        this.id = id;
        this.categoryName = categoryName;
        this.birth = birth;
        this.blogList = blogList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
