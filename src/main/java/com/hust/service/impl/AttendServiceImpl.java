package com.hust.service.impl;

import com.hust.entity.AttendEntity;
import com.hust.model.AttendInputModel;
import com.hust.repo.ActivityRepo;
import com.hust.repo.AttendRepo;
import com.hust.repo.VolunteerRepo;
import com.hust.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    AttendRepo attendRepo;
    @Autowired
    VolunteerRepo volunteerRepo;
    @Autowired
    ActivityRepo activityRepo;

    @Override
    public List<AttendEntity> findAll() {
        return attendRepo.findAll();
    }

    @Override
    public AttendEntity save(AttendInputModel input) {
        AttendEntity attend = attendRepo.findByActivityIdAndVolunteerId(input.getActivityId(), input.getVolunteerId());
        if(attend != null){
            attend.setSkill(input.getSkill());
            attendRepo.save(attend);
        } else {
            attend = new AttendEntity();
            attend.setVolunteer(volunteerRepo.findById(input.getVolunteerId()));
            attend.setActivity(activityRepo.findById(input.getActivityId()));
            attend.setSkill(input.getSkill());
            attend = attendRepo.save(attend);
        }
        return attend;
    }

    @Override
    public void delete(long id) {
        attendRepo.deleteById(id);
    }
}
