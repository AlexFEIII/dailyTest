package com.pro.daily.domain.DailyNote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GameCUpvote {
    @Id
    @GeneratedValue
    private Integer id;
    private int commentid;
    private String username;

    public GameCUpvote(){}
    public GameCUpvote(int commentid,String username){
        this.commentid = commentid;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
