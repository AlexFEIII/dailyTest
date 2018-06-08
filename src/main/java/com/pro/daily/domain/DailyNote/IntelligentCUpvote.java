package com.pro.daily.domain.DailyNote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IntelligentCUpvote {
    @Id
    @GeneratedValue
    private Integer id;
    private int commentid;
    private String username;

    public IntelligentCUpvote(){}
    public IntelligentCUpvote(int commentid,String username){
        this.commentid = commentid;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }
    public int getCommentid() {
        return commentid;
    }
    public String getUsername() {
        return username;
    }
}
