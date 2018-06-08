package com.pro.daily.dailyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @RequestMapping({"/index.html"})
    public String web(){
        return "index";
    }

    @RequestMapping("/app.html")
    public String getApp(){return "app";}

    @RequestMapping("/best_on_the_web.html")
    public String getBest(){return "best_on_the_web";}

    @RequestMapping("/big_company.html")
    public String getBigcompany(){
        return "big_company";
    }

    @RequestMapping("business.html")
    public String getBusiness(){return "business";}

    @RequestMapping("/city.html")
    public String getCity(){return "city";}

    @RequestMapping("/column.html")
    public String getColumn(){return "column";}

    @RequestMapping("/design.html")
    public String getDesign(){
        return "design";
    }

    @RequestMapping("/fashion.html")
    public String getFashion(){return "fashion";}

    @RequestMapping("/game.html")
    public String getGame(){return "game";}

    @RequestMapping("/happiness.html")
    public String getHappiness(){
        return "happiness";
    }

    @RequestMapping("/html/house.html")
    public String getHouse(){return "house";}

    @RequestMapping("/long_article.html")
    public String getLong(){return "long_article";}

    @RequestMapping("/magic.html")
    public String getMagic(){
        return "magic";
    }

    @RequestMapping("/picture.html")
    public String getPicture(){return "picture";}

    @RequestMapping("/html/research.html")
    public String getResearch(){return "research";}

    @RequestMapping("/Top 15.html")
    public String getTop15(){
        return "Top 15";
    }

    @RequestMapping({"/use_ agreement.html","/use_ agreement.html#privacy","/use_ agreement.html#copyright"})
    public String getAgreement(){return "use_ agreement";}

    @RequestMapping("/userCenter.html")
    public String getUserCenter(){return "userCenter";}
}
