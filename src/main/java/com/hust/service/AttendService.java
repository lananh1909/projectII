package com.hust.service;

import com.hust.entity.AttendEntity;
import com.hust.entity.id.AttendId;
import com.hust.model.AttendInputModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendService {
    List<AttendEntity> findAll();
    AttendEntity save(AttendInputModel input);
    void deleteAttend(AttendId id);
    List<AttendEntity> findByActivity(long id);
}
