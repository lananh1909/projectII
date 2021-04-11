package com.hust.controller;

import com.hust.model.ActivityInputModel;
import com.hust.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class ActivityAPIController {
    @Autowired
    ActivityService activityService;

    @PostMapping("/create-activity")
    public ResponseEntity<?> createActivity(Principal principal, @RequestBody ActivityInputModel input){
        return ResponseEntity.ok().body(activityService.save(input));
    }

    @GetMapping("/get-all-activity")
    public ResponseEntity<?> getAllActivity(Principal principal){
        return ResponseEntity.ok().body(activityService.findAll());
    }

    @PutMapping("/update-activity/{id}")
    public ResponseEntity<?> updateActivity(@RequestBody ActivityInputModel input, @PathVariable("id") long id){
        return ResponseEntity.ok().body(activityService.save(input, id));
    }

    @DeleteMapping("/delete-activity")
    public void deleteActivity(@RequestBody long id){
        activityService.delete(id);
    }

    @PostMapping("/get-volunteers")
    public ResponseEntity<?> getVolunteers(@RequestBody long activityId){
        return ResponseEntity.ok().body(activityService.getVolunteers(activityId));
    }
}
