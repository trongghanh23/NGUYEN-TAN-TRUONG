package com.code_gym.blogs.repository;
import com.code_gym.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * " +
            "FROM blog where category = :id",
            nativeQuery = true)
    List<Blog> blogOfCategory(@Param("id") int id);

    @Query(value = " select * from blog where blog_name like %:searchName% ", nativeQuery = true)
    List<Blog> findSearchNameBlog( @Param("searchName") String searchName );
}
