package com.hust.service;

import com.hust.entity.BlogEntity;
import com.hust.entity.UserEntity;
import com.hust.model.AddUserInputModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity save(AddUserInputModel user);
    List<UserEntity> findAll();
    UserEntity save(AddUserInputModel input, long id);
    void delete(long id);
    List<BlogEntity> getBlogs(long userId);
}
