package com.hust.service.impl;

import com.hust.entity.TopicEntity;
import com.hust.repo.TopicRepo;
import com.hust.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepo topicRepo;

    @Override
    public List<TopicEntity> findAll() {
        return topicRepo.findAll();
    }

    @Override
    public TopicEntity save(String name) {
        TopicEntity topic = new TopicEntity();
        topic.setTopicName(name);
        topic = topicRepo.save(topic);
        return topic;
    }

    @Override
    public TopicEntity save(String name, long id) {
        TopicEntity topic = topicRepo.findById(id);
        topic.setTopicName(name);
        topic = topicRepo.save(topic);
        return topic;
    }

    @Override
    public void delete(long id) {
        topicRepo.deleteById(id);
    }
}
