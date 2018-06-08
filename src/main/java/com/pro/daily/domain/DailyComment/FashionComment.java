package com.pro.daily.domain.DailyComment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class FashionComment {
    @Id
    @GeneratedValue
    private Integer id;
    private int documentid;
    private int commentid;
    private String commentuser;
    @Column(length = 16384)
    private String commentcontent;
    private Date date;
    private int upvotenum;

    public FashionComment(){}
    public FashionComment(int documentid,int commentid,String commentuser,String commentcontent){
        this.documentid = documentid;
        this.commentid = commentid;
        this.commentuser = commentuser;
        this.commentcontent = commentcontent;
        date = new Date();
    }
    public FashionComment(int documentid,String commentuser,String commentcontent){
        this.documentid = documentid;
        this.commentuser = commentuser;
        this.commentcontent = commentcontent;
        date = new Date();
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDocumentid() {
        return documentid;
    }

    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    public String getCommentuser() {
        return commentuser;
    }

    public void setCommentuser(String commentuser) {
        this.commentuser = commentuser;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUpvotenum() {
        return upvotenum;
    }

    public void setUpvotenum(int upvotenum) {
        this.upvotenum = upvotenum;
    }
}
