package com.pro.daily.dailyService.impl;

import com.pro.daily.dailyRepository.CommentRepository.*;
import com.pro.daily.dailyRepository.CuriosityRepository.DailyCuriositySchoolRepository;
import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.dailyService.CommentService;
import com.pro.daily.domain.DailyComment.*;
import com.pro.daily.domain.DailyCuriosity.DailyCuriositySchool;
import com.pro.daily.domain.DailyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private BusinessCommentRepository businessCommentRepository;
    @Autowired
    private CityCommentRepository cityCommentRepository;
    @Autowired
    private CuriosityCommentRepository curiosityCommentRepository;
    @Autowired
    private DesignCommentRepository designCommentRepository;
    @Autowired
    private DocumentCommentRepository documentCommentRepository;
    @Autowired
    private EntertainmentCommentRepository entertainmentCommentRepository;
    @Autowired
    private FashionCommentRepository fashionCommentRepository;
    @Autowired
    private GameCommentRepository gameCommentRepository;
    @Autowired
    private IntelligentCommentRepository intelligentCommentRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DailyCuriositySchoolRepository dailyCuriositySchoolRepository;

    //保存评论的评论
    public void saveBusinessCommentService(int document,int commentid,String commentuser,String commentcontent){
        businessCommentRepository.save(new BusinessComment(document,commentid,commentuser,commentcontent));
    }
    public void saveCityCommentService(int document,int commentid,String commentuser,String commentcontent){
        cityCommentRepository.save(new CityComment(document,commentid,commentuser,commentcontent));
    }
    public void saveDesignCommentService(int document,int commentid,String commentuser,String commentcontent){
        designCommentRepository.save(new DesignComment(document,commentid,commentuser,commentcontent));
    }
    public void saveDocumentCommentService(int document,int commentid,String commentuser,String commentcontent){
        documentCommentRepository.save(new DocumentComment(document,commentid,commentuser,commentcontent));
    }
    public void saveEntertainmentCommentService(int document,int commentid,String commentuser,String commentcontent){
        entertainmentCommentRepository.save(new EntertainmentComment(document,commentid,commentuser,commentcontent));
    }
    public void saveFashionCommentService(int document,int commentid,String commentuser,String commentcontent){
        fashionCommentRepository.save(new FashionComment(document,commentid,commentuser,commentcontent));
    }
    public void saveGameCommentService(int document,int commentid,String commentuser,String commentcontent){
        gameCommentRepository.save(new GameComment(document,commentid,commentuser,commentcontent));
    }
    public void saveIntelligentCommentService(int document,int commentid,String commentuser,String commentcontent){
        intelligentCommentRepository.save(new IntelligentComment(document,commentid,commentuser,commentcontent));
    }

    //保存文章的评论
    public void saveBusinessCommentService(int document,String commentuser,String commentcontent){
        businessCommentRepository.save(new BusinessComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveCityCommentService(int document,String commentuser,String commentcontent){
        cityCommentRepository.save(new CityComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveDesignCommentService(int document,String commentuser,String commentcontent){
        designCommentRepository.save(new DesignComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveDocumentCommentService(int document,String commentuser,String commentcontent){
        documentCommentRepository.save(new DocumentComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveEntertainmentCommentService(int document,String commentuser,String commentcontent){
        entertainmentCommentRepository.save(new EntertainmentComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveFashionCommentService(int document,String commentuser,String commentcontent){
        fashionCommentRepository.save(new FashionComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveGameCommentService(int document,String commentuser,String commentcontent){
        gameCommentRepository.save(new GameComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }
    public void saveIntelligentCommentService(int document,String commentuser,String commentcontent){
        intelligentCommentRepository.save(new IntelligentComment(document,commentuser,commentcontent));
        commentNumAdd(document);
    }

    //好奇心 我说 ：（）.
    public void saveCuriosityCommentService(int documentid,String commentuser,String commentcontent,String image){
        curiosityCommentRepository.save(new CuriosityComment(documentid,commentuser,commentcontent,image));
        //好奇心 参与人数 +1
        DailyCuriositySchool dailyCuriositySchool = dailyCuriositySchoolRepository.findById(documentid);
        dailyCuriositySchool.setPeople(dailyCuriositySchool.getPeople()+1);
    }
    //文章 评论数+1
    public void commentNumAdd(int documentid){
        System.out.println("documentid: "+documentid);
        DailyDocument dailyDocument = documentRepository.findById(documentid);
        dailyDocument.setCommentnum(dailyDocument.getCommentnum()+1);
        documentRepository.save(dailyDocument);
    }

    public List<BusinessComment> showBusinessCService(int documentid,int num){
        if(num == 0){
            try{
                return businessCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return businessCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return businessCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return businessCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<CityComment> showCityCService(int documentid,int num){
        if(num == 0){
            try{
                return cityCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return cityCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return cityCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return cityCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<CuriosityComment> showCuriosityCService(int documentid,int num){
        if(num == 0){
            try{
                return curiosityCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return curiosityCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return curiosityCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return curiosityCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<DesignComment> showDesignCService(int documentid,int num){
        if(num == 0){
            try{
                return designCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return designCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return designCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return designCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<DocumentComment> showDocumentCService(int documentid,int num){
        if(num == 0){
            try{
                return documentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return documentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return documentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return documentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<EntertainmentComment> showEntertainmentCService(int documentid,int num){
        if(num == 0){
            try{
                return entertainmentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return entertainmentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return entertainmentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return entertainmentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<FashionComment> showFashionCService(int documentid,int num){
        if(num == 0){
            try{
                return fashionCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return fashionCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return fashionCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return fashionCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<GameComment> showGameCService(int documentid,int num){
        if(num == 0){
            try{
                return gameCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return gameCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return gameCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return gameCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
    public List<IntelligentComment> showIntelligentCService(int documentid,int num){
        if(num == 0){
            try{
                return intelligentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(0,40);
            } catch (Exception e){
                return intelligentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }else{
            try{
                return intelligentCommentRepository.findByDocumentidOrderByIdDesc(documentid).subList(num,num+20);
            }catch (Exception e){
                return intelligentCommentRepository.findByDocumentidOrderByIdDesc(documentid);
            }
        }
    }
}
