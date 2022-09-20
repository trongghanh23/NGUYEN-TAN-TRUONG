package com.example.form.service;

import com.example.form.model.User;


import java.util.List;

public interface IUserService {
    List<User>userList();

    void save(User user);
}
