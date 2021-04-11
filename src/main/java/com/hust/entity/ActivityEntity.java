package com.hust.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hust.address.entity.Commune;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"activity\"")
public class ActivityEntity extends BaseEntity{
    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String location;

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private UserEntity user;

    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private List<AttendEntity> attendees = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<AttendEntity> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<AttendEntity> attendees) {
        this.attendees = attendees;
    }
}
