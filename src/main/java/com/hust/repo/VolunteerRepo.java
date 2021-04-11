package com.hust.repo;

import com.hust.entity.VolunteerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepo extends JpaRepository<VolunteerEntity, Long> {
    public List<VolunteerEntity> findAll();
    public VolunteerEntity save(VolunteerEntity volunteer);
    VolunteerEntity findById(long id);
}
