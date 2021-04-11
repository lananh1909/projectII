package com.hust.repo;

import com.hust.entity.AttendEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendRepo extends JpaRepository<AttendEntity, Long> {
    List<AttendEntity> findAll();
    AttendEntity save(AttendEntity attend);
    AttendEntity findById(long id);
    List<AttendEntity> findByActivityId(long id);
    List<AttendEntity> findByVolunteerId(long id);
    AttendEntity findByActivityIdAndVolunteerId(long actId, long volId);
}
