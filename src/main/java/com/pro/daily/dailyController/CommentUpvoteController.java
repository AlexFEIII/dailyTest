package com.pro.daily.dailyController;

import com.pro.daily.dailyService.*;
import com.pro.daily.dailyService.impl.CommentServiceImpl;
import com.pro.daily.dailyService.impl.UploadImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CommentUpvoteController {

    @Autowired
    UpvoteService upvoteService;

    @Autowired
    CommentService commentService;

    @PostMapping("saveDComment")
    public void saveDComment(@RequestParam("documentType") String documentType,
                            @RequestParam("documentid") int documentid,
                            @RequestParam("commentuser") String commentuser,
                            @RequestParam("commentcontent") String commentcontent){
        if(documentType.equals("business")) commentService.saveBusinessCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("city")) commentService.saveCityCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("design")) commentService.saveDesignCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("document")) commentService.saveDocumentCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("entertainment")) commentService.saveEntertainmentCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("fashion")) commentService.saveFashionCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("game")) commentService.saveGameCommentService(documentid,commentuser,commentcontent);
        else commentService.saveIntelligentCommentService(documentid,commentuser,commentcontent);
    }
    @PostMapping("saveCComment")
    public void saveCComment(@RequestParam("documentType") String documentType,
                             @RequestParam("documentid") int documentid,
                             @RequestParam("commentuser") String commentuser,
                             @RequestParam("commentcontent") String commentcontent){
        if(documentType.equals("business")) commentService.saveBusinessCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("city")) commentService.saveCityCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("design")) commentService.saveDesignCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("document")) commentService.saveDocumentCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("entertainment")) commentService.saveEntertainmentCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("fashion")) commentService.saveFashionCommentService(documentid,commentuser,commentcontent);
        else if(documentType.equals("game")) commentService.saveGameCommentService(documentid,commentuser,commentcontent);
        else commentService.saveIntelligentCommentService(documentid,commentuser,commentcontent);
    }

    @PostMapping("saveCuriosityComment")
    public void saveCuriosityComment(@RequestParam("documentid") int documentid,
                                     @RequestParam("commentuser") String commentuser,
                                     @RequestParam("commentcontent") String commentcontent,
                                     @RequestParam MultipartFile multipartFile){
        new CommentServiceImpl().saveCuriosityCommentService(documentid,commentuser,commentcontent,new UploadImageServiceImpl().uploadHeadImage(multipartFile));
    }

    @PostMapping("saveDUpvote")
    public void saveUpload(@RequestParam("documentid") int documentid,
                           @RequestParam("username") String username){
        upvoteService.upvoteDList(documentid,username);
    }

    @PostMapping("saveCUpvote")
    public void saveCUpvote(@RequestParam("documentType") String documentType,
                            @RequestParam("commentid") int commentid,
                            @RequestParam("username") String username){
        if(documentType.equals("business")) upvoteService.upvoteCBusiness(commentid,username);
        else if(documentType.equals("city")) upvoteService.upvoteCCity(commentid,username);
        else if(documentType.equals("design")) upvoteService.upvoteCDesign(commentid,username);
        else if(documentType.equals("document")) upvoteService.upvoteCDocument(commentid,username);
        else if(documentType.equals("entertainment")) upvoteService.upvoteCEntertainment(commentid,username);
        else if(documentType.equals("fashion")) upvoteService.upvoteCFashion(commentid,username);
        else if(documentType.equals("game")) upvoteService.upvoteCGame(commentid,username);
        else upvoteService.upvoteCIntelligent(commentid,username);
    }
}
