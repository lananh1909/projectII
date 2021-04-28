package com.hust.service.impl;

import com.hust.address.repo.CommuneRepo;
import com.hust.converter.ActivityConverter;
import com.hust.entity.ActivityEntity;
import com.hust.entity.AttendEntity;
import com.hust.entity.ListImage;
import com.hust.entity.VolunteerEntity;
import com.hust.model.ActivityInputModel;
import com.hust.model.ActivityOutputModel;
import com.hust.model.ActivityPaging;
import com.hust.repo.*;
import com.hust.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    FileDBRepo fileDBRepo;

    @Autowired
    ListImageRepo listImageRepo;

    @Override
    public List<ActivityOutputModel> findAll() {
        List<ActivityEntity> acts = activityRepo.findAll();
        List<ActivityOutputModel> out = new ArrayList<>();
        for(ActivityEntity a: acts){
            out.add(ActivityConverter.toOutPutModel(a));
        }
        return out;
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
        act.setImage(fileDBRepo.findById(input.getFileId()));
        act.setFromDate(input.getFromDate());
        act.setToDate(input.getToDate());
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
        act.setImage(fileDBRepo.findById(input.getFileId()));
        act.setFromDate(input.getFromDate());
        act.setToDate(input.getToDate());
        act = activityRepo.save(act);
        return act;
    }

    @Override
    public void delete(long id) {
        ActivityEntity ac = activityRepo.findById(id);
        activityRepo.delete(ac);
        List<ActivityEntity> acts = activityRepo.findByImage(ac.getImage());
        List<ListImage> imgs = listImageRepo.findByImageId(ac.getImage().getId());
        if(acts.size() == 1 && imgs.size() == 0){
            fileDBRepo.delete(ac.getImage());
        }
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

    @Override
    public ActivityOutputModel getActiviy(long id) {
        return ActivityConverter.toOutPutModel(activityRepo.findById(id));
    }

    @Override
    public ActivityPaging findAll(Pageable pageable) {
        Page<ActivityEntity> activities = activityRepo.findAll(pageable);
        List<ActivityEntity> acts = activities.getContent();
        List<ActivityOutputModel> out = new ArrayList<>();
        for (ActivityEntity a : acts) {
            out.add(ActivityConverter.toOutPutModel(a));
        }
        return new ActivityPaging(activities.getNumber(), activities.getTotalElements(), activities.getTotalPages(), out);
    }

    @Override
    public ActivityPaging findAllByTitle(String title, Pageable pageable) {
        Page<ActivityEntity> activities = activityRepo.findByTitleContainingIgnoreCase(title, pageable);
        List<ActivityEntity> acts = activities.getContent();
        List<ActivityOutputModel> out = new ArrayList<>();
        for (ActivityEntity a : acts) {
            out.add(ActivityConverter.toOutPutModel(a));
        }
        return new ActivityPaging(activities.getNumber(), activities.getTotalElements(), activities.getTotalPages(), out);
    }
}
