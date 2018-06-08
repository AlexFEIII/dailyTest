package com.pro.daily.domain.DailyUserPackage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pro.daily.domain.DailyCuriosity.CuriosityResult;

import javax.persistence.*;
import java.util.List;

@Entity
public class DailyUser {
    @Id
    @GeneratedValue
    private Integer id;
    //昵称
    private String nickname;
    @JsonIgnore
    private String password;
    //邮箱
    private String username;
    private String headimage;
    private String role;
    private String personality;

    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "user_result",joinColumns = {@JoinColumn(name = "userid")},inverseJoinColumns = {@JoinColumn(name = "resultid")})
    @JsonIgnore
    private List<CuriosityResult> curiosityResults;

    public List<CuriosityResult> getCuriosityResults() {
        return curiosityResults;
    }

    public void setCuriosityResults(List<CuriosityResult> curiosityResults) {
        this.curiosityResults = curiosityResults;
    }

    public DailyUser(){}
    public DailyUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }
}
