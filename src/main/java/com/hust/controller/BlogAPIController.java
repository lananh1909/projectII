package com.hust.controller;

import com.hust.entity.BlogEntity;
import com.hust.model.AddBlogInputModel;
import com.hust.repo.BlogRepo;
import com.hust.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class BlogAPIController {
    @Autowired
    BlogService blogService;

    @PostMapping("/create-blog")
    public ResponseEntity<?> createBlog(Principal principal, @RequestBody AddBlogInputModel input){
        BlogEntity blog = blogService.save(input);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/get-all-blogs")
    public ResponseEntity<?> getAllBlogs(Principal principal){
        List<BlogEntity> blogs = blogService.findAll();
        return ResponseEntity.ok().body(blogs);
    }

    @PutMapping("/update-blog/{id}")
    public ResponseEntity<?> upDateBlog(@RequestBody AddBlogInputModel input, @PathVariable("id") long id){
        BlogEntity blog = blogService.save(input, id);
        return ResponseEntity.ok().body(blog);
    }

    @DeleteMapping("/delete-blog")
    public ResponseEntity<?> deleteBlog(@RequestBody long id){
        blogService.delete(id);
        return ResponseEntity.ok().body("Xoa thanh cong");
    }
}
