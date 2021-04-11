package com.hust.service.impl;

import com.hust.address.repo.CommuneRepo;
import com.hust.entity.ActivityEntity;
import com.hust.entity.AttendEntity;
import com.hust.entity.VolunteerEntity;
import com.hust.model.ActivityInputModel;
import com.hust.repo.ActivityRepo;
import com.hust.repo.AttendRepo;
import com.hust.repo.TopicRepo;
import com.hust.repo.UserRepo;
import com.hust.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityRepo activityRepo;

    @Autowired
    CommuneRepo communeRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TopicRepo topicRepo;

    @Autowired
    AttendRepo attendRepo;

    @Override
    public List<ActivityEntity> findAll() {
        return activityRepo.findAll();
    }

    @Override
    public ActivityEntity save(ActivityInputModel input) {
        ActivityEntity act = new ActivityEntity();
        act.setTitle(input.getTitle());
        act.setContent(input.getContent());
        act.setLocation(input.getLocation());
        act.setCommune(communeRepo.findByCommuneId(input.getCommuneId()));
        act.setTopic(topicRepo.findById(input.getTopicId()));
        act.setUser(userRepo.findById(input.getUserId()));
        act = activityRepo.save(act);
        return act;
    }

    @Override
    public ActivityEntity save(ActivityInputModel input, long id) {
        ActivityEntity act = activityRepo.findById(id);
        act.setTitle(input.getTitle());
        act.setContent(input.getContent());
        act.setLocation(input.getLocation());
        act.setCommune(communeRepo.findByCommuneId(input.getCommuneId()));
        act.setTopic(topicRepo.findById(input.getTopicId()));
        act.setUser(userRepo.findById(input.getUserId()));
        act = activityRepo.save(act);
        return act;
    }

    @Override
    public void delete(long id) {
        activityRepo.deleteById(id);
    }

    @Override
    public List<VolunteerEntity> getVolunteers(long id) {
        List<AttendEntity> attends = attendRepo.findByActivityId(id);
        List<VolunteerEntity> volunteers = new ArrayList<>();
        for(AttendEntity at: attends){
            volunteers.add(at.getVolunteer());
        }
        return volunteers;
    }
}
