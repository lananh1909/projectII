package com.hust.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hust.address.entity.Commune;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"volunteer\"")
public class VolunteerEntity extends BaseEntity{
    @Column
    private String fullName;

    @Column
    private String phoneNum;

    @Column
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "volunteer")
    @JsonIgnore
    private List<AttendEntity> attends = new ArrayList<>();

    public List<AttendEntity> getAttends() {
        return attends;
    }

    public void setAttends(List<AttendEntity> attends) {
        this.attends = attends;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
