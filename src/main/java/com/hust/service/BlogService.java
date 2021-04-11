package com.hust.service;

import com.hust.entity.BlogEntity;
import com.hust.model.AddBlogInputModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    BlogEntity save(AddBlogInputModel input);
    List<BlogEntity> findAll();
    BlogEntity save(AddBlogInputModel input, long id);
    void delete(long id);
}
