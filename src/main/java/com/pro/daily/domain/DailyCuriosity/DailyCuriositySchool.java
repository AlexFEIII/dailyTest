package com.pro.daily.domain.DailyCuriosity;

import javax.persistence.*;
import java.sql.Blob;

//除投票外的文章：

@Entity
public class DailyCuriositySchool {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String sontitle;
    //参与人数
    private int people;
    private String type;
    @Column(length = 131072)
    private String content;
    private int percent20;
    private int percent40;
    private int percent60;
    private int percent80;
    private int percent100;

    public DailyCuriositySchool(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPercent20() {
        return percent20;
    }

    public void setPercent20(int percent20) {
        this.percent20 = percent20;
    }

    public int getPercent40() {
        return percent40;
    }

    public void setPercent40(int percent40) {
        this.percent40 = percent40;
    }

    public int getPercent60() {
        return percent60;
    }

    public void setPercent60(int percent60) {
        this.percent60 = percent60;
    }

    public int getPercent80() {
        return percent80;
    }

    public void setPercent80(int percent80) {
        this.percent80 = percent80;
    }

    public int getPercent100() {
        return percent100;
    }

    public void setPercent100(int percent100) {
        this.percent100 = percent100;
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

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
