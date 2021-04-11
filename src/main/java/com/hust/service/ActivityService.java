package com.hust.service;

import com.hust.entity.ActivityEntity;
import com.hust.entity.VolunteerEntity;
import com.hust.model.ActivityInputModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    List<ActivityEntity> findAll();
    ActivityEntity save(ActivityInputModel input);
    ActivityEntity save(ActivityInputModel input, long id);
    void delete(long id);
    List<VolunteerEntity> getVolunteers(long id);
}
