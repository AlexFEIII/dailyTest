package com.pro.daily.dailyController;

import com.pro.daily.dailyRepository.CuriosityRepository.CuriosityResultRepository;
import com.pro.daily.dailyRepository.CuriosityRepository.DailyCuriositySchoolRepository;
import com.pro.daily.dailyRepository.DailyVoteDocumentRepository;
import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
import com.pro.daily.domain.DailyCuriosity.CuriosityResult;
import com.pro.daily.domain.DailyCuriosity.DailyCuriositySchool;
import com.pro.daily.domain.DailyCuriosity.DailyVoteDocument;
import com.pro.daily.domain.DailyUserPackage.DailyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActiveController {
    @Autowired
    private CuriosityResultRepository curiosityResultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyCuriositySchoolRepository dailyCuriositySchoolRepository;

    @Autowired
    private DailyVoteDocumentRepository dailyVoteDocumentRepository;

    //保存测试结果
    @PostMapping("TestResult")
    public List<CuriosityResult> saveAndSendResult(@RequestParam("titleid") int titleid,
                                                   @RequestParam("result") int result,
                                                   @RequestParam("thinkresult") int thinkresult){
        //邮箱通过token
        String email = "123456";
        boolean flag = false;
        DailyUser dailyUser = userRepository.findByUsername(email);
        List<CuriosityResult> curiosityResults = dailyUser.getCuriosityResults();
        for(CuriosityResult c : curiosityResults){
            if (c.getDocumentid() == titleid){
                CuriosityResult findResult = c;
                findResult.setResult(result);
                findResult.setThinkresult(thinkresult);
                curiosityResultRepository.save(findResult);
                flag = true;
                break;
            }
        }
        //保存 五段的人数
        DailyCuriositySchool dailyCuriositySchool = dailyCuriositySchoolRepository.findById(titleid);
        switch(result){
            case 0:
            case 1:
            case 2:
                dailyCuriositySchool.setPercent20(dailyCuriositySchool.getPercent20()+1);
                break;
            case 3:
            case 4:
                dailyCuriositySchool.setPercent40(dailyCuriositySchool.getPercent40()+1);
                break;
            case 5:
            case 6:
                dailyCuriositySchool.setPercent60(dailyCuriositySchool.getPercent60()+1);
                break;
            case 7:
            case 8:
                dailyCuriositySchool.setPercent80(dailyCuriositySchool.getPercent80()+1);
            case 9:
            case 10:
                dailyCuriositySchool.setPercent100(dailyCuriositySchool.getPercent100()+1);
        }
        if (flag == false)
            curiosityResultRepository.save(new CuriosityResult(titleid,result,thinkresult,dailyUser));
        int num = curiosityResultRepository.findByDocumentid(titleid).size();
        if(num > 12){
            return curiosityResultRepository.findByDocumentid(titleid).subList(num-1,num-12);
        }
        return curiosityResultRepository.findByDocumentid(titleid);

    }
    @PostMapping("TestPercent")
    public DailyCuriositySchool returnTestPercent(@RequestParam("titleid") int titleid){
        return dailyCuriositySchoolRepository.findById(titleid);
    }

//保存我猜结果
    @PostMapping("iGuess")
    public void iGuess(@RequestParam int documentid,
                                  @RequestParam int truenum){
        String email = "123456";
        DailyUser dailyUser = userRepository.findByUsername(email);
        boolean flag = false;
        List<CuriosityResult> curiosityResults = dailyUser.getCuriosityResults();
        for(CuriosityResult c : curiosityResults){
            if(c.getDocumentid() == documentid){
                c.setTruenum(truenum);
                curiosityResultRepository.save(c);
                flag = true;
                break;
            }
        }
        if (flag == false) curiosityResultRepository.save(new CuriosityResult(documentid,truenum,dailyUser));
    }

//    保存投票结果
    @PostMapping("makeAChoose")
    public DailyVoteDocument returnChoosePercent(@RequestParam("titleid") int titleid,
                                                 @RequestParam("chooseList") int[] chooseList){
        DailyVoteDocument dailyVoteDocument = dailyVoteDocumentRepository.findById(titleid);
        for(int i : chooseList){
            if(i == 1) dailyVoteDocument.setOne(dailyVoteDocument.getOne()+1);
            else if(i == 2) dailyVoteDocument.setTwo(dailyVoteDocument.getTwo()+1);
            else if(i == 3) dailyVoteDocument.setThree(dailyVoteDocument.getThree()+1);
            else if(i == 4) dailyVoteDocument.setFour(dailyVoteDocument.getFour()+1);
            else if(i == 5) dailyVoteDocument.setFive(dailyVoteDocument.getFive()+1);
            else if(i == 6) dailyVoteDocument.setSix(dailyVoteDocument.getSix()+1);
            else if(i == 7) dailyVoteDocument.setSeven(dailyVoteDocument.getSeven()+1);
            else if(i == 8) dailyVoteDocument.setEight(dailyVoteDocument.getEight()+1);
            else if(i == 9) dailyVoteDocument.setNine(dailyVoteDocument.getNine()+1);
            else if(i == 10) dailyVoteDocument.setTen(dailyVoteDocument.getTen()+1);
            else if(i == 11) dailyVoteDocument.setEleven(dailyVoteDocument.getEleven()+1);
            else if(i == 12) dailyVoteDocument.setTwelve(dailyVoteDocument.getTwelve()+1);
            else if(i == 13) dailyVoteDocument.setThirteen(dailyVoteDocument.getThirteen()+1);
            else if(i == 14) dailyVoteDocument.setFourteen(dailyVoteDocument.getFourteen()+1);
            else if(i == 15) dailyVoteDocument.setFifteen(dailyVoteDocument.getFifteen()+1);
            else if(i == 16) dailyVoteDocument.setSixteen(dailyVoteDocument.getSixteen()+1);
            else if(i == 17) dailyVoteDocument.setSeventeen(dailyVoteDocument.getSeventeen()+1);
            else if(i == 18) dailyVoteDocument.setEighteen(dailyVoteDocument.getEighteen()+1);
            else if(i == 19) dailyVoteDocument.setNineteen(dailyVoteDocument.getNineteen()+1);
            else dailyVoteDocument.setTwenty(dailyVoteDocument.getTwenty()+1);
        }
        dailyVoteDocumentRepository.save(dailyVoteDocument);
        return dailyVoteDocument;
    }
}
