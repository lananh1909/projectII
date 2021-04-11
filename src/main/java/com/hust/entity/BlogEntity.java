package com.hust.entity;


import javax.persistence.*;

@Entity
@Table(name = "\"blogs\"")
public class BlogEntity extends BaseEntity{
    @Column
    private String title;

    @Column
    private String Content;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private UserEntity user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
