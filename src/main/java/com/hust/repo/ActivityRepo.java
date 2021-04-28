package com.hust.repo;

import com.hust.entity.ActivityEntity;
import com.hust.entity.FileDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ActivityRepo extends JpaRepository<ActivityEntity, Long> {
    List<ActivityEntity> findAll();
    ActivityEntity save(ActivityEntity act);
    ActivityEntity findById(long id);
    List<ActivityEntity> findByImage(FileDB image);
    Page<ActivityEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
