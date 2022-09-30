package com.code_gym.blog.repository;


import com.code_gym.blog.entity.AppUser;
import com.code_gym.blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
