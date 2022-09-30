package com.code_gym.blog.repository;

import com.code_gym.blog.dto.IBlogDto;
import com.code_gym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "SELECT b.blog_name as blogName, c.category_name as categoryName " +
            "FROM blog b join category c on b.id = c.id",
            nativeQuery = true)
    List<IBlogDto> searchByTitle();
}
