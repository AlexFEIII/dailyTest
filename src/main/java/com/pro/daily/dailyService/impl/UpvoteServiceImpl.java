package com.pro.daily.dailyService.impl;

import com.pro.daily.dailyRepository.CommentRepository.*;
import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.dailyRepository.NoteRepository.*;
import com.pro.daily.dailyService.UpvoteService;
import com.pro.daily.domain.DailyComment.*;
import com.pro.daily.domain.DailyDocument;
import com.pro.daily.domain.DailyNote.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpvoteServiceImpl implements UpvoteService {
    @Autowired
    private BusinessCommentRepository businessCommentRepository;
    @Autowired
    private BusinessCUpvoteRepository businessCUpvoteRepository;
    @Autowired
    private CityCommentRepository cityCommentRepository;
    @Autowired
    private CityCUpvoteRepository cityCUpvoteRepository;
    @Autowired
    private CuriosityCommentRepository curiosityCommentRepository;
    @Autowired
    private CuriosityCUpvoteRepository curiosityCUpvoteRepository;
    @Autowired
    private DesignCommentRepository designCommentRepository;
    @Autowired
    private DesignCUpvoteRepository designCUpvoteRepository;
    @Autowired
    private DocumentCommentRepository documentCommentRepository;
    @Autowired
    private DocumentCUpvoteRepository documentCUpvoteRepository;
    @Autowired
    private EntertainmentCommentRepository entertainmentCommentRepository;
    @Autowired
    private EntertainmentCUpvoteRepository entertainmentCUpvoteRepository;
    @Autowired
    private FashionCommentRepository fashionCommentRepository;
    @Autowired
    private FashionCUpvoteRepository fashionCUpvoteRepository;
    @Autowired
    private GameCommentRepository gameCommentRepository;
    @Autowired
    private GameCUpvoteRepository gameCUpvoteRepository;
    @Autowired
    private IntelligentCommentRepository intelligentCommentRepository;
    @Autowired
    private IntelligentCUpvoteRepository intelligentCUpvoteRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentUpvoteListRepository documentUpvoteListRepository;

    public void upvoteDList(int documentid,String username){
        DailyDocument dailyDocument = documentRepository.findById(documentid);
        DocumentUpvoteList documentUpvoteList = documentUpvoteListRepository.findByUsernameAndDocumentid(username,documentid);
        if(documentUpvoteList != null){
            documentUpvoteListRepository.delete(documentUpvoteList.getId());
            dailyDocument.setUpvotenum(dailyDocument.getUpvotenum()-1);
        }else{
            documentUpvoteListRepository.save(new DocumentUpvoteList(documentid,username));
            dailyDocument.setUpvotenum(dailyDocument.getUpvotenum()+1);
        }
        documentRepository.save(dailyDocument);
    }

    public void upvoteCBusiness(int commentid,String username){
        BusinessComment businessComment = businessCommentRepository.findById(commentid);
        BusinessCUpvote businessCUpvote = businessCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        if(businessCUpvote == null){
            businessCUpvoteRepository.save(new BusinessCUpvote(commentid,username));
            businessComment.setUpvotenum(businessComment.getUpvotenum()+1);
        }else{
            businessCUpvoteRepository.delete(businessCUpvote.getId());
            businessComment.setUpvotenum(businessComment.getUpvotenum()-1);
        }
        businessCommentRepository.save(businessComment);
    }
    public void upvoteCCity(int commentid,String username){
        CityCUpvote cityCUpvote = cityCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        CityComment cityComment = cityCommentRepository.findById(commentid);
        if(cityCUpvote != null){
            cityCUpvoteRepository.delete(cityCUpvote.getId());
            cityComment.setUpvotenum(cityComment.getUpvotenum()-1);
        }else {
            cityCUpvoteRepository.save(new CityCUpvote(commentid,username));
            cityComment.setUpvotenum(cityComment.getUpvotenum()+1);
        }
        cityCommentRepository.save(cityComment);
    }
    public void upvoteCCuriosity(int commentid,String username){
        CuriosityCUpvote curiosityCUpvote = curiosityCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        CuriosityComment curiosityComment = curiosityCommentRepository.findById(commentid);
        if (curiosityCUpvote != null){
            curiosityCUpvoteRepository.delete(curiosityCUpvote.getId());
            curiosityComment.setUpvotenum(curiosityComment.getUpvotenum()-1);
        }else {
            curiosityCUpvoteRepository.save(new CuriosityCUpvote(commentid,username));
            curiosityComment.setUpvotenum(curiosityComment.getUpvotenum()+1);
        }
        curiosityCommentRepository.save(curiosityComment);
    }
    public void upvoteCDesign(int commentid,String username){
        DesignCUpvote designCUpvote = designCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        DesignComment designComment = designCommentRepository.findById(commentid);
        if (designCUpvote != null){
            designCUpvoteRepository.delete(designCUpvote.getId());
            designComment.setUpvotenum(designComment.getUpvotenum()-1);
        }else{
            designCUpvoteRepository.save(new DesignCUpvote(commentid,username));
            designComment.setUpvotenum(designComment.getUpvotenum()+1);
        }
        designCommentRepository.save(designComment);
    }
    public void upvoteCDocument(int commentid,String username){
        DocumentCUpvote documentCUpvote = documentCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        DocumentComment documentComment = documentCommentRepository.findById(commentid);
        if(documentCUpvote != null){
            documentCUpvoteRepository.delete(documentCUpvote.getId());
            documentComment.setUpvotenum(documentComment.getUpvotenum()-1);
        }else{
            documentCUpvoteRepository.save(new DocumentCUpvote(commentid,username));
            documentComment.setUpvotenum(documentComment.getUpvotenum()+1);
        }
        documentCommentRepository.save(documentComment);
    }
    public void upvoteCEntertainment(int commentid,String username){
        EntertainmentCUpvote entertainmentCUpvote = entertainmentCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        EntertainmentComment entertainmentComment = entertainmentCommentRepository.findById(commentid);
        if(entertainmentCUpvote != null){
            entertainmentCUpvoteRepository.delete(entertainmentCUpvote.getId());
            entertainmentComment.setUpvotenum(entertainmentComment.getUpvotenum()-1);
        }else {
            entertainmentCUpvoteRepository.save(new EntertainmentCUpvote(commentid,username));
            entertainmentComment.setUpvotenum(entertainmentComment.getUpvotenum()+1);
        }
        entertainmentCommentRepository.save(entertainmentComment);
    }
    public void upvoteCFashion(int commentid,String username){
        FashionCUpvote fashionCUpvote = fashionCUpvoteRepository.findByCommentidAndUsername(commentid,username);
        FashionComment fashionComment = fashionCommentRepository.findById(commentid);
        if(fashionCUpvote != null){
            fashionCUpvoteRepository.delete(fashionCUpvote.getId());
            fashionComment.setUpvotenum(fashionComment.getUpvotenum()-1);
        }else{
            fashionCUpvoteRepository.save(new FashionCUpvote(commentid,username));
            fashionComment.setUpvotenum(fashionComment.getUpvotenum()+1);
        }
        fashionCommentRepository.save(fashionComment);
    }
    public void upvoteCGame(int commentid,String username){
        GameCUpvote gameCUpvote = gameCUpvoteRepository.findByCommentidAndUsername(commentid, username);
        GameComment gameComment = gameCommentRepository.findById(commentid);
        if(gameCUpvote != null){
            gameCUpvoteRepository.delete(gameCUpvote.getId());
            gameComment.setUpvotenum(gameComment.getUpvotenum()-1);
        }else{
            gameCUpvoteRepository.save(new GameCUpvote(commentid,username));
            gameComment.setUpvotenum(gameComment.getUpvotenum()+1);
        }
        gameCommentRepository.save(gameComment);
    }
    public void upvoteCIntelligent(int commentid,String username){
        IntelligentCUpvote intelligentCUpvote = intelligentCUpvoteRepository.findByCommentidAndUsername(commentid, username);
        IntelligentComment intelligentComment = intelligentCommentRepository.findById(commentid);
        if(intelligentCUpvote != null){
            intelligentCUpvoteRepository.delete(intelligentCUpvote.getId());
            intelligentComment.setUpvotenum(intelligentComment.getUpvotenum()-1);
        }else{
            intelligentCUpvoteRepository.save(new IntelligentCUpvote(commentid,username));
            intelligentComment.setUpvotenum(intelligentComment.getUpvotenum()+1);
        }
        intelligentCommentRepository.save(intelligentComment);
    }

    public List<DocumentUpvoteList> showUpvoteDList(String username){  //返回收藏的文章
        return documentUpvoteListRepository.findByUsername(username);
    }
    public boolean showUpvoteCBusiness(int commentid,String username){ //查看评论 是否已经点赞
        if(businessCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true; //已经点赞
        return false;
    }
    public boolean showUpvoteCCity(int commentid,String username){
        if(cityCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCCuriosity(int commentid,String username){
        if(curiosityCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCDesign(int commentid,String username){
        if(designCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCDocument(int commentid,String username){
        if(documentCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCEntertainment(int commentid,String username){
        if(entertainmentCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCFashion(int commentid,String username){
        if(fashionCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCGame(int commentid,String username){
        if(gameCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
    public boolean showUpvoteCIntelligent(int commentid,String username){
        if(intelligentCUpvoteRepository.findByCommentidAndUsername(commentid,username) != null)
            return true;
        return false;
    }
}
