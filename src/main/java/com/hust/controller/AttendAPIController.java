package com.hust.controller;

import com.hust.model.AttendInputModel;
import com.hust.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AttendAPIController {
    @Autowired
    AttendService attendService;

    @PostMapping("/insert-attend")
    public ResponseEntity<?> insertAttend(Principal principal, @RequestBody AttendInputModel input){
        return ResponseEntity.ok().body(attendService.save(input));
    }

    @GetMapping("/get-all-attend")
    public ResponseEntity<?> getAllAttend(Principal principal){
        return ResponseEntity.ok().body(attendService.findAll());
    }

    @PutMapping("/update-attend")
    public ResponseEntity<?> updateAttend(@RequestBody AttendInputModel input){
        return ResponseEntity.ok().body(attendService.save(input));
    }

    @DeleteMapping("/delete-attend")
    public void deleteAttend(@RequestBody long id){
        attendService.delete(id);
    }
}
