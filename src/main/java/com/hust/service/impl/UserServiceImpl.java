package com.hust.service.impl;

import com.hust.entity.BlogEntity;
import com.hust.entity.UserEntity;
import com.hust.model.AddUserInputModel;
import com.hust.repo.RoleRepo;
import com.hust.repo.UserRepo;
import com.hust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public UserEntity save(AddUserInputModel user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(roleRepo.findOneById(user.getRoleId()));
        userEntity = userRepo.save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = userRepo.findAll();
        return users;
    }

    @Override
    public UserEntity save(AddUserInputModel input, long id) {
        UserEntity user = userRepo.getOne(id);
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setRole(roleRepo.findOneById(input.getRoleId()));
        user = userRepo.save(user);
        return user;
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<BlogEntity> getBlogs(long userId) {
        UserEntity user = userRepo.findById(userId);
        return user.getBlogs();
    }
}
