package com.hust.service;

import com.hust.entity.ActivityEntity;
import com.hust.entity.VolunteerEntity;
import com.hust.model.VolunteerInputModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VolunteerService {
    VolunteerEntity save(VolunteerInputModel volunteer);
    List<VolunteerEntity> findAll();
    VolunteerEntity save(VolunteerInputModel input, long id);
    void delete(long id);
    List<ActivityEntity> getActivities(long id);
}
