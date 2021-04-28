package com.hust.controller;

import com.hust.entity.id.AttendId;
import com.hust.model.AttendInputModel;
import com.hust.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AttendAPIController {
    @Autowired
    AttendService attendService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/insert-attend")
    public ResponseEntity<?> insertAttend(Principal principal, @RequestBody AttendInputModel input){
        return ResponseEntity.ok().body(attendService.save(input));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-attend/{id}")
    public ResponseEntity<?> getAllAttend(Principal principal, @PathVariable("id") long id){
        return ResponseEntity.ok().body(attendService.findByActivity(id));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update-attend")
    public ResponseEntity<?> updateAttend(@RequestBody AttendInputModel input){
        return ResponseEntity.ok().body(attendService.save(input));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/delete-attend")
    public void deleteAttend(@RequestBody AttendId input){
        attendService.deleteAttend(input);
    }
}
