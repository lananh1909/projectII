package com.hust.controller;

import com.hust.entity.UserEntity;
import com.hust.model.AddUserInputModel;
import com.hust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserAPIController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(Principal principal, @RequestBody AddUserInputModel input){
        UserEntity userEntity = userService.save(input);
        return ResponseEntity.ok().body(userEntity);
    }

    @GetMapping("/get-users")
    public ResponseEntity<?> getAllUsers(Principal principal){
        List<UserEntity> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody AddUserInputModel input, @PathVariable("id") long id){
        UserEntity user = userService.save(input, id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestBody long id){
        userService.delete(id);
    }

    @PostMapping("/get-blogs")
    public ResponseEntity<?> getBlogs(@RequestBody long userId){
        return ResponseEntity.ok().body(userService.getBlogs(userId));
    }
}
