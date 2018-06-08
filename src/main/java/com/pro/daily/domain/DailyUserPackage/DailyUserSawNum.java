package com.pro.daily.domain.DailyUserPackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DailyUserSawNum {
    @Id
    @GeneratedValue
    private Integer id;
    private String user;
    //技术宅访问次数
    private int technology;
    //金融访问次数
    private int finance;
    //开脑洞访问次数
    private int brain;
    //颜控访问次数
    private int face;
    //二次元访问次数
    private int manga;

    public DailyUserSawNum(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }

    public int getFinance() {
        return finance;
    }

    public void setFinance(int finance) {
        this.finance = finance;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getManga() {
        return manga;
    }

    public void setManga(int manga) {
        this.manga = manga;
    }
}
