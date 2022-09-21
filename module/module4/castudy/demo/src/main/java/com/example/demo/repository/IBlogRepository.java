package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select id, `name`, title, category\n" +
            "from blog\n" +
            "where `name` like :keyword ", nativeQuery = true)
    List<Blog> searchStudentWithName(@Param("keyword") String nameStudent);

//
//    @Query(value = " select * from blogger where name like :searchName ", nativeQuery = true,
//            countQuery = " select count(*) from (select * from blogger where name like :searchName ) temp_table ")
//    Page<Blogger> getAllBlog(@Param("searchName") String searchName , Pageable pageable);
}
