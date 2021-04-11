package com.hust.service.impl;

import com.hust.config.JpaAuditingConfig;
import com.hust.entity.BlogEntity;
import com.hust.model.AddBlogInputModel;
import com.hust.repo.BlogRepo;
import com.hust.repo.UserRepo;
import com.hust.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    BlogRepo blogRepo;

    @Override
    public BlogEntity save(AddBlogInputModel input) {
        BlogEntity blog = new BlogEntity();
        blog.setTitle(input.getTitle());
        blog.setContent(input.getContent());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        blog.setUser(userRepo.findByUsername(authentication.getName()));
        blog = blogRepo.save(blog);
        return blog;
    }

    @Override
    public List<BlogEntity> findAll() {
        List<BlogEntity> blogs = blogRepo.findAll();
        return blogs;
    }

    @Override
    public BlogEntity save(AddBlogInputModel input, long id) {
        BlogEntity blog = blogRepo.findOneById(id);
        blog.setTitle(input.getTitle());
        blog.setContent(input.getContent());
        blog = blogRepo.save(blog);
        return blog;
    }

    @Override
    public void delete(long id) {
        blogRepo.deleteById(id);
    }
}
