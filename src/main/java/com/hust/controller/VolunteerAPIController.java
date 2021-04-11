package com.hust.controller;

import com.hust.entity.VolunteerEntity;
import com.hust.model.VolunteerInputModel;
import com.hust.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class VolunteerAPIController {
    @Autowired
    public VolunteerService volunteerService;

    @GetMapping("/get-all-volunteer")
    public ResponseEntity<?> getAllVolunteer(Principal principal){
        List<VolunteerEntity> volunteerEntities = volunteerService.findAll();
        return ResponseEntity.ok().body(volunteerEntities);
    }

    @PostMapping("/create-volunteer")
    public ResponseEntity<?> createVolunteer(Principal principal, @RequestBody VolunteerInputModel input){
        VolunteerEntity volunteer = volunteerService.save(input);
        return ResponseEntity.ok().body(volunteer);
    }

    @PutMapping("/update-volunteer/{id}")
    public ResponseEntity<?> updateVolunteer(@RequestBody VolunteerInputModel input, @PathVariable("id") long id){
        VolunteerEntity volunteerEntity = volunteerService.save(input, id);
        return ResponseEntity.ok().body(volunteerEntity);
    }

    @DeleteMapping("/delete-volunteer")
    public void deleteVolunteer(@RequestBody long id){
        volunteerService.delete(id);
    }
}
