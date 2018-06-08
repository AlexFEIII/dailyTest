package com.pro.daily.domain.DailyComment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//好奇心评论

@Entity
public class CuriosityComment {
    @Id
    @GeneratedValue
    private Integer id;
    private int documentid;
    private String commentuser;
    @Column(length = 16384)
    private String commentcontent;
    private Date date;
    private String image;
    private int upvotenum;

    public CuriosityComment(){}
    public CuriosityComment(int documentid,String commentuser,String commentcontent,String image){
        this.documentid = documentid;
        this.commentuser = commentuser;
        this.commentcontent = commentcontent;
        this.image = image;
        date = new Date();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUpvotenum() {
        return upvotenum;
    }

    public void setUpvotenum(int upvotenum) {
        this.upvotenum = upvotenum;
    }
}
