package com.pro.daily.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DailyTheBest {
    @Id
    @GeneratedValue
    private Integer id;
    //标题
    private String title;
    //副标题
    private String sontitle;
    //文章的内容
    @Column(length = 65536)
    private String content;
    //点赞个数
    private String upvotenum;
    //评论个数
    private String commentnum;
    //文章发表时间
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSontitle() {
        return sontitle;
    }

    public void setSontitle(String sontitle) {
        this.sontitle = sontitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpvotenum() {
        return upvotenum;
    }

    public void setUpvotenum(String upvotenum) {
        this.upvotenum = upvotenum;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DailyTheBest(){}
}
