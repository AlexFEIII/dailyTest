package com.pro.daily.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class DailyDocument {
    @Id
    @GeneratedValue
    private Integer id;
    //标题
    private String title;
    //副标题
    private String sontitle;
    //文章图片
    private String titleimage;
    //文章的内容
    @Column(length = 65536)
    private String content;
    //点赞个数
    private int upvotenum;
    //评论个数
    private int commentnum;
    //文章发表时间

    private Date date;
    //文章所属类型
    @JsonIgnore
    private String type;
    //是否是长文章
    @JsonIgnore
    private boolean islong;
    //是否是10个图
    @JsonIgnore
    private boolean istenimage;
    //是否是Top15
    @JsonIgnore
    private boolean istop15;
    //是否是今日应用
    @JsonIgnore
    private boolean isapp;
    //是否是Q Business
    @JsonIgnore
    private boolean isbusiness;
    //是否是100个有想法的人
    @JsonIgnore
    private boolean isthought;
    //是否是medium
    @JsonIgnore
    private boolean ismedium;
    //是否是这世界
    @JsonIgnore
    private boolean isworld;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name = "document_column",joinColumns = {@JoinColumn(name = "documentid")},inverseJoinColumns = {@JoinColumn(name = "columnid")})
    @JsonIgnore
    private List<DailyColumn> columns;

    public Integer getId() {
        return id;
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

    public String getTitleimage() {
        return titleimage;
    }

    public void setTitleimage(String titleimage) {
        this.titleimage = titleimage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUpvotenum() {
        return upvotenum;
    }

    public void setUpvotenum(int upvotenum) {
        this.upvotenum = upvotenum;
    }

    public int getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DailyColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DailyColumn> columns) {
        this.columns = columns;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIslong() {
        return islong;
    }

    public void setIslong(boolean islong) {
        this.islong = islong;
    }

    public boolean isIstenimage() {
        return istenimage;
    }

    public void setIstenimage(boolean istenimage) {
        this.istenimage = istenimage;
    }

    public boolean isIstop15() {
        return istop15;
    }

    public void setIstop15(boolean istop15) {
        this.istop15 = istop15;
    }

    public boolean isIsapp() {
        return isapp;
    }

    public void setIsapp(boolean isapp) {
        this.isapp = isapp;
    }

    public boolean isIsbusiness() {
        return isbusiness;
    }

    public void setIsbusiness(boolean isbusiness) {
        this.isbusiness = isbusiness;
    }

    public boolean isIsthought() {
        return isthought;
    }

    public void setIsthought(boolean isthought) {
        this.isthought = isthought;
    }

    public boolean isIsmedium() {
        return ismedium;
    }

    public void setIsmedium(boolean ismedium) {
        this.ismedium = ismedium;
    }

    public boolean isIsworld() {
        return isworld;
    }

    public void setIsworld(boolean isworld) {
        this.isworld = isworld;
    }

    public DailyDocument(){}
    public DailyDocument(String title,String sonTitle,String titleimage,String type){
        this.title = title;
        this.sontitle = sonTitle;
        this.titleimage = titleimage;
        this.type = type;
    }
}
