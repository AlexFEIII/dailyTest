package com.pro.daily.domain.DailyUserPackage;

import javax.persistence.*;

@Entity
public class DailyUserCollect {
    @Id
    @GeneratedValue
    private Integer id;
    private int userid;
    private String collect;

    public DailyUserCollect(){}

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
