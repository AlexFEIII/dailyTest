package com.pro.daily.dailyController;

import com.pro.daily.dailyRepository.DailyColumnRepository;
import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
import com.pro.daily.dailyService.CommentService;
import com.pro.daily.domain.DailyComment.*;
import com.pro.daily.domain.DailyDocument;
import com.pro.daily.domain.DailyNote.DocumentUpvoteList;
import com.pro.daily.domain.DailyUserPackage.DailyUser;
import com.pro.daily.domain.DailyUserPackage.DailyUserCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    CommentService commentService;

    //显示 可重复类型 的文章
    @GetMapping("Top15Click")
    public List<DailyDocument> returnTop(){
        try {
            return documentRepository.findByIstop15OrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIstop15OrderByIdDesc(true);
        }
    }
    @GetMapping("LongClick")
    public List<DailyDocument> returnLong(){
        try {
            return documentRepository.findByIslongOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIslongOrderByIdDesc(true);
        }
    }
    @GetMapping("TenImageClick")
    public List<DailyDocument> returnTenImage(){
        try {
            return documentRepository.findByIstenimageOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIstenimageOrderByIdDesc(true);
        }
    }
    @GetMapping("AppClick")
    public List<DailyDocument> returnApp(){
        try {
            return documentRepository.findByIsappOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIsappOrderByIdDesc(true);
        }
    }
    @GetMapping("BusinessClick")
    public List<DailyDocument> returnBusiness(){
        try {
            return documentRepository.findByIsbusinessOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIsbusinessOrderByIdDesc(true);
        }
    }
    @GetMapping("ThoughtClick")
    public List<DailyDocument> returnThought(){
        try {
            return documentRepository.findByIsthoughtOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIsthoughtOrderByIdDesc(true);
        }
    }
    @GetMapping("MediumClick")
    public List<DailyDocument> returnMedium(){
        try {
            return documentRepository.findByIsmediumOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIsmediumOrderByIdDesc(true);
        }
    }
    @GetMapping("WorldClick")
    public List<DailyDocument> returnWorld(){
        try {
            return documentRepository.findByIsworldOrderByIdDesc(true).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByIsworldOrderByIdDesc(true);
        }
    }

    //显示 类型 文章
    @PostMapping("TypeClick")
    public List<DailyDocument> returnType(@RequestParam("documentType") String type){
        try {
            return documentRepository.findByTypeOrderByIdDesc(type).subList(0,40);
        }catch (Exception e){
            return documentRepository.findByTypeOrderByIdDesc(type);
        }

    }

    //加载后续文章
    @PostMapping("Top15Next")
    public List<DailyDocument> Top15Next(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIstop15OrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIstop15OrderByIdDesc(true).subList(num,documentRepository.findByIstop15OrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("LongNext")
    public List<DailyDocument> LongNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIslongOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIslongOrderByIdDesc(true).subList(num,documentRepository.findByIslongOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("TenImageNext")
    public List<DailyDocument> TenImageNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIstenimageOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIstenimageOrderByIdDesc(true).subList(num,documentRepository.findByIstenimageOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("AppNext")
    public List<DailyDocument> AppNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIsappOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIsappOrderByIdDesc(true).subList(num,documentRepository.findByIsappOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("BusinessNext")
    public List<DailyDocument> BusinessNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIsbusinessOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIsbusinessOrderByIdDesc(true).subList(num,documentRepository.findByIsbusinessOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("ThoughtNext")
    public List<DailyDocument> ThoughtNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIsthoughtOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIsthoughtOrderByIdDesc(true).subList(num,documentRepository.findByIsthoughtOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("MediumNext")
    public List<DailyDocument> MediumNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIsmediumOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIsmediumOrderByIdDesc(true).subList(num,documentRepository.findByIsmediumOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("WorldNext")
    public List<DailyDocument> WorldNext(@RequestParam("documentNum") int num){
        try{
            return documentRepository.findByIsworldOrderByIdDesc(true).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByIsworldOrderByIdDesc(true).subList(num,documentRepository.findByIsworldOrderByIdDesc(true).size()-num);
        }
    }
    @PostMapping("TypeNext")
    public List<DailyDocument> TypeNext(@RequestParam("documentType") String type,
                                        @RequestParam("documentNum") int num){
        try{
            return documentRepository.findByTypeOrderByIdDesc(type).subList(num,num+20);
        }catch (Exception e){
            return documentRepository.findByTypeOrderByIdDesc(type).subList(num,documentRepository.findByTypeOrderByIdDesc(type).size()-num);
        }
    }

    //根据栏目显示
    @PostMapping("columnDocumentShow")
    public List<DailyDocument> columnDocumentShow(@RequestParam("columnName") String name){
        return null;
    }

    //显示文章评论
    @PostMapping("showBusinessComment")
    public List<BusinessComment> showBusinessComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showBusinessCService(documentid,num);
    }
    @PostMapping("showCityComment")
    public List<CityComment> showCityComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showCityCService(documentid,num);
    }
    @PostMapping("showCuriosityComment")
    public List<CuriosityComment> showCuriosityComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showCuriosityCService(documentid,num);
    }
    @PostMapping("showDesignComment")
    public List<DesignComment> showDesignComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showDesignCService(documentid,num);
    }
    @PostMapping("showDocumentComment")
    public List<DocumentComment> showDocumentComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showDocumentCService(documentid,num);
    }
    @PostMapping("showEntertainmentComment")
    public List<EntertainmentComment> showEntertainmentComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showEntertainmentCService(documentid,num);
    }
    @PostMapping("showFashionComment")
    public List<FashionComment> showFashionComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showFashionCService(documentid,num);
    }
    @PostMapping("showGameComment")
    public List<GameComment> showGameComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showGameCService(documentid,num);
    }
    @PostMapping("showIntelligentComment")
    public List<IntelligentComment> showIntelligentComment(@RequestParam int documentid, @RequestParam int num){
        return commentService.showIntelligentCService(documentid,num);
    }

    //显示 点赞 中 的文章点赞（即 我的收藏 功能）
    @GetMapping("showMyCollect")
    public List<DocumentUpvoteList> showMyCollect(){
        return null;
    }

    //后台管理页面用户表and文章表的显示
    @GetMapping("BUser")
    public List<DailyUser> showBUser(){
        return userRepository.findAll();
    }
    @GetMapping("BDoc")
    public List<DailyDocument> showBDoc(){
        return documentRepository.findAll();
    }
}
