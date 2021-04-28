package com.hust.controller;


import com.hust.entity.TopicEntity;
import com.hust.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TopicAPIController {
    @Autowired
    TopicService topicService;

    @PostMapping("/create-topic")
    public ResponseEntity<?> createTopic(Principal principal, @RequestBody String name){
        TopicEntity topic = topicService.save(name);
        return ResponseEntity.ok().body(topic);
    }

    @GetMapping("/get-all-topic")
    public ResponseEntity<?> getAllTopic(Principal principal){
        List<TopicEntity> topics = topicService.findAll();
        return ResponseEntity.ok().body(topics);
    }

    @PutMapping("/update-topic/{id}")
    public ResponseEntity<?> updateTopic(@RequestBody String name, @PathVariable("id") long id){
        return ResponseEntity.ok().body(topicService.save(name, id));
    }

    @DeleteMapping("/delete-topic")
    public void deleteTopic(@RequestBody long id){
        topicService.delete(id);
    }
}
