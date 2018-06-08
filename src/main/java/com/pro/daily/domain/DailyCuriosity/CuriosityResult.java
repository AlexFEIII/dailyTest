package com.pro.daily.domain.DailyCuriosity;

import com.pro.daily.domain.DailyUserPackage.DailyUser;

import javax.persistence.*;
import java.util.List;

//保存 42% 测试结果和预期结果 以及 我猜 猜中的个数
@Entity
public class CuriosityResult {
    @Id
    @GeneratedValue
    private Integer id;
    private int documentid;
    //42 结果和 预测结果
    private int result;
    private int thinkresult;
    //我猜猜中的个数
    private int truenum;

    public int getTruenum() {
        return truenum;
    }

    public void setTruenum(int truenum) {
        this.truenum = truenum;
    }

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "user_result",joinColumns = {@JoinColumn(name = "resultid")},inverseJoinColumns = {@JoinColumn(name = "userid")})
    private DailyUser dailyUser;

    public DailyUser getDailyUser() {
        return dailyUser;
    }

    public void setDailyUser(DailyUser dailyUser) {
        this.dailyUser = dailyUser;
    }

    public int getDocumentid() {
        return documentid;
    }

    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getThinkresult() {
        return thinkresult;
    }

    public void setThinkresult(int thinkresult) {
        this.thinkresult = thinkresult;
    }

    public CuriosityResult(){}
    public CuriosityResult(int documentid,int result, int thinkresult,DailyUser dailyUser){
        this.documentid = documentid;
        this.result = result;
        this.thinkresult = thinkresult;
        this.dailyUser = dailyUser;
    }
    public CuriosityResult(int documentid,int truenum,DailyUser dailyUser){
        this.documentid = documentid;
        this.truenum = truenum;
        this.dailyUser = dailyUser;
    }
}
