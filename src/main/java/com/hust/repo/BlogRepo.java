package com.hust.repo;

import com.hust.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<BlogEntity, Long> {
    BlogEntity findOneById(long id);
    List<BlogEntity> findAll();
    BlogEntity save(BlogEntity blog);
}
