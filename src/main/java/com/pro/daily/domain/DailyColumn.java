package com.pro.daily.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
public class DailyColumn {
    @Id
    @GeneratedValue
    private Integer id;
    //栏目名称
    private String name;
    //栏目作者
    private String writer;
    //订阅人数
    private int peoplenum;
    //文章数
    private int documentnum;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "document_column",joinColumns = {@JoinColumn(name = "columnid")},inverseJoinColumns = {@JoinColumn(name = "documentid")})
    private List<DailyDocument> dailyDocuments;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }

    public int getDocumentnum() {
        return documentnum;
    }

    public void setDocumentnum(int documentnum) {
        this.documentnum = documentnum;
    }

    public List<DailyDocument> getDailyDocuments() {
        return dailyDocuments;
    }

    public void setDailyDocuments(List<DailyDocument> dailyDocuments) {
        this.dailyDocuments = dailyDocuments;
    }

    public DailyColumn(){}
}
