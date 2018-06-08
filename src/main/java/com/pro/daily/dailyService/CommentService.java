package com.pro.daily.dailyService;

import com.pro.daily.domain.DailyComment.*;

import java.util.List;

public interface CommentService {
    //评论的评论
    public void saveBusinessCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveCityCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveDesignCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveDocumentCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveEntertainmentCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveFashionCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveGameCommentService(int document,int commentid,String commentuser,String commentcontent);
    public void saveIntelligentCommentService(int document,int commentid,String commentuser,String commentcontent);
    //文章评论
    public void saveBusinessCommentService(int document,String commentuser,String commentcontent);
    public void saveCityCommentService(int document,String commentuser,String commentcontent);
    public void saveDesignCommentService(int document,String commentuser,String commentcontent);
    public void saveDocumentCommentService(int document,String commentuser,String commentcontent);
    public void saveEntertainmentCommentService(int document,String commentuser,String commentcontent);
    public void saveFashionCommentService(int document,String commentuser,String commentcontent);
    public void saveGameCommentService(int document,String commentuser,String commentcontent);
    public void saveIntelligentCommentService(int document,String commentuser,String commentcontent);
    //好奇心 我说
    public void saveCuriosityCommentService(int documentid,String commentuser,String commentcontent,String image);

    //评论显示
    public List<BusinessComment> showBusinessCService(int documentid,int num);
    public List<CityComment> showCityCService(int documentid,int num);
    public List<CuriosityComment> showCuriosityCService(int documentid,int num);
    public List<DesignComment> showDesignCService(int documentid,int num);
    public List<DocumentComment> showDocumentCService(int documentid,int num);
    public List<EntertainmentComment> showEntertainmentCService(int documentid,int num);
    public List<FashionComment> showFashionCService(int documentid,int num);
    public List<GameComment> showGameCService(int documentid,int num);
    public List<IntelligentComment> showIntelligentCService(int documentid,int num);
}
