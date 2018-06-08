package com.pro.daily.domain.DailyNote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//文章点赞
@Entity
public class DocumentUpvoteList {
    @Id
    @GeneratedValue
    private Integer id;
    private int documentid;
    private String username;

    public DocumentUpvoteList(){}
    public DocumentUpvoteList(int documentid,String username){
        this.documentid = documentid;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public int getDocumentid() {
        return documentid;
    }

    public String getUsername() {
        return username;
    }
}
