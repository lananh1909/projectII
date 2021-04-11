package com.hust.service.impl;

import com.hust.address.repo.CommuneRepo;
import com.hust.entity.ActivityEntity;
import com.hust.entity.AttendEntity;
import com.hust.entity.VolunteerEntity;
import com.hust.model.VolunteerInputModel;
import com.hust.repo.AttendRepo;
import com.hust.repo.UserRepo;
import com.hust.repo.VolunteerRepo;
import com.hust.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    CommuneRepo communeRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    VolunteerRepo volunteerRepo;

    @Autowired
    AttendRepo attendRepo;

    @Override
    public VolunteerEntity save(VolunteerInputModel volunteer) {
        VolunteerEntity vol = new VolunteerEntity();
        vol.setFullName(volunteer.getFullName());
        vol.setBirthDate(volunteer.getBirthDate());
        vol.setPhoneNum(volunteer.getPhoneNum());
        vol.setCommune(communeRepo.findByCommuneId(volunteer.getCommuneId()));
        vol.setUser(userRepo.findById(volunteer.getUserId()));
        vol = volunteerRepo.save(vol);
        return vol;
    }

    @Override
    public List<VolunteerEntity> findAll() {
        List<VolunteerEntity> volunteers = volunteerRepo.findAll();
        return volunteers;
    }

    @Override
    public VolunteerEntity save(VolunteerInputModel input, long id) {
        VolunteerEntity volunteer = volunteerRepo.findById(id);
        volunteer.setFullName(input.getFullName());
        volunteer.setBirthDate(input.getBirthDate());
        volunteer.setPhoneNum(input.getPhoneNum());
        volunteer.setCommune(communeRepo.findByCommuneId(input.getCommuneId()));
        volunteer.setUser(userRepo.findById(input.getUserId()));
        volunteer = volunteerRepo.save(volunteer);
        return volunteer;
    }

    @Override
    public void delete(long id) {
        volunteerRepo.deleteById(id);
    }

    @Override
    public List<ActivityEntity> getActivities(long id) {
        List<AttendEntity> attends = attendRepo.findByVolunteerId(id);
        List<ActivityEntity> activities = new ArrayList<>();
        for(AttendEntity act: attends){
            activities.add(act.getActivity());
        }
        return activities;
    }
}
