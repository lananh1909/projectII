package com.hust.service;

import com.hust.entity.TopicEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    List<TopicEntity> findAll();
    TopicEntity save(String name);
    TopicEntity save(String name, long id);
    void delete(long id);
}
