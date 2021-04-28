package com.hust.controller;

import com.hust.model.ActivityInputModel;
import com.hust.model.ActivityOutputModel;
import com.hust.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/activity")
public class ActivityAPIController {
    @Autowired
    ActivityService activityService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-activity")
    public ResponseEntity<?> createActivity(Principal principal, @RequestBody ActivityInputModel input){
        return ResponseEntity.ok().body(activityService.save(input));
    }

    @GetMapping("/get-all-activity")
    public ResponseEntity<?> getAllActivity(Principal principal){
        return ResponseEntity.ok().body(activityService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-activity/{id}")
    public ResponseEntity<?> updateActivity(@RequestBody ActivityInputModel input, @PathVariable("id") long id){
        return ResponseEntity.ok().body(activityService.save(input, id));
    }

    @GetMapping("/get-activity/{id}")
    public ResponseEntity<?> getActivity(@PathVariable("id") long id){
        return ResponseEntity.ok().body(activityService.getActiviy(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-activity")
    public void deleteActivity(@RequestBody long id){
        activityService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/get-volunteers")
    public ResponseEntity<?> getVolunteers(@RequestBody long activityId){
        return ResponseEntity.ok().body(activityService.getVolunteers(activityId));
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getAtivities(@RequestParam(required = false) String title,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        if(title == null){
            return ResponseEntity.ok().body(activityService.findAll(pageable));
        } else {
            return ResponseEntity.ok().body(activityService.findAllByTitle(title, pageable));
        }
    }
}
