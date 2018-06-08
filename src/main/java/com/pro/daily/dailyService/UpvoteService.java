package com.pro.daily.dailyService;

import com.pro.daily.domain.DailyNote.DocumentUpvoteList;

import java.util.List;

public interface UpvoteService {
    //点赞
    public void upvoteDList(int document,String username);
    public void upvoteCBusiness(int commentid,String username);
    public void upvoteCCity(int commentid,String username);
    public void upvoteCCuriosity(int commentid,String username);
    public void upvoteCDesign(int commentid,String username);
    public void upvoteCDocument(int commentid,String username);
    public void upvoteCEntertainment(int commentid,String username);
    public void upvoteCFashion(int commentid,String username);
    public void upvoteCGame(int commentid,String username);
    public void upvoteCIntelligent(int commentid,String username);

    //显示 我的收藏
    public List<DocumentUpvoteList> showUpvoteDList(String username);

    //判断 评论 是否已经点赞
    public boolean showUpvoteCBusiness(int commentid,String username);
    public boolean showUpvoteCCity(int commentid,String username);
    public boolean showUpvoteCCuriosity(int commentid,String username);
    public boolean showUpvoteCDesign(int commentid,String username);
    public boolean showUpvoteCDocument(int commentid,String username);
    public boolean showUpvoteCEntertainment(int commentid,String username);
    public boolean showUpvoteCFashion(int commentid,String username);
    public boolean showUpvoteCGame(int commentid,String username);
    public boolean showUpvoteCIntelligent(int commentid,String username);
}
