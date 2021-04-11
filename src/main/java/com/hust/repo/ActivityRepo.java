package com.hust.repo;

import com.hust.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepo extends JpaRepository<ActivityEntity, Long> {
    List<ActivityEntity> findAll();
    ActivityEntity save(ActivityEntity act);
    ActivityEntity findById(long id);
}
