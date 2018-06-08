package com.pro.daily.dailyController;

import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
import com.pro.daily.dailyService.UploadImageService;
import com.pro.daily.dailyService.UserService;
import com.pro.daily.domain.DailyUserPackage.DailyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UploadImageService uploadImageService;

    @Autowired
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @PostMapping("registerEmail")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        if (userService.findEmail(username)){
            //邮箱已经注册
            return "ReMail";
        }else {
            userRepository.save(new DailyUser(username,passwordEncoder().encode(password)));
            return "yes";
        }
    }

    @PostMapping("registerFinal")
    public String registerFinal(@RequestParam(value = "headImage",required = false) MultipartFile file,
                              @RequestParam("username") String username,  //邮箱
                              @RequestParam("nickname") String nickname,  //昵称
                              @RequestParam("personality") String per){
        DailyUser dailyUser = userRepository.findByUsername(username);
        //处理昵称
        if (nickname != null){
            dailyUser.setNickname(nickname);
            userRepository.save(dailyUser);
        }
        //处理一句话介绍自己
        if(per != null){
            dailyUser.setPersonality(per);
            userRepository.save(dailyUser);
        }
        //处理头像
        if (file != null){
            if(file.getSize() <= 1024*1024*2){
                if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") ||
                        file.getContentType().equals("image/bmp") || file.getContentType().equals("image/gif") ||
                        file.getContentType().equals("image/jpg")){
                    dailyUser.setHeadimage("http://p6yz4djye.bkt.clouddn.com/"+ uploadImageService.uploadHeadImage(file));
                    userRepository.save(dailyUser);
                }else{
                    return "wrongType";
                }
            }else{
                return "soBIG";
            }
        }
        return "yes";
    }

    @PostMapping("changePass")
    public boolean changePass(@RequestParam String password,
                           @RequestParam String changePassword){
        if (userService.changePassService(password,changePassword)){
            return true;
        }
        return false;
    }

    @GetMapping("isLogin")
    public DailyUser isLogin(HttpSession session){
        if (session.isNew()) {
            return null;
        }
        try{
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("用户名："+userDetails.getUsername()+"\r\n密码"+userDetails.getPassword());
            return userRepository.findByUsername(userDetails.getUsername());
        }catch (Exception e){
            return null;
        }


    }

    @PostMapping("uploadImage")
    public String uploadImage(@RequestParam MultipartFile uploadHeadimage){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DailyUser dailyUser = userRepository.findByUsername(userDetails.getUsername());
        dailyUser.setHeadimage(uploadImageService.uploadHeadImage(uploadHeadimage));
        userRepository.save(dailyUser);
        return "yes";
    }
/*    @PostMapping("login")
    public DailyUser login(@RequestParam String mail,
                        @RequestParam String pass){
        DailyUser dailyUser = userRepository.findByUsername(mail);
        if (dailyUser.getPassword().equals(pass)){
            return dailyUser;
        }
        return null;
    }*/
}
