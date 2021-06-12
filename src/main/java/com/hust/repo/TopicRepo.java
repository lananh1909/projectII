package com.hust.repo;

import com.hust.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public interface TopicRepo extends JpaRepository<TopicEntity, Long> {
    List<TopicEntity> findAll();
    TopicEntity save(TopicEntity topic);
    TopicEntity findById(long id);
    boolean existsByTopicName(String topicName);
    boolean existsByTopicNameAndIdNot(String name, long id);
}
