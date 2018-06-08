package com.pro.daily.dailyService.impl;

import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
import com.pro.daily.dailyService.UserService;
import com.pro.daily.domain.DailyUserPackage.DailyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    public boolean findEmail(String mail){
        DailyUser dailyUser = userRepository.findByUsername(mail);
        if(dailyUser == null){
            return false;
        }else if(dailyUser != null && dailyUser.getNickname() == null){
            userRepository.delete(dailyUser.getId());
            return false;
        }
        return true;
    }

    public boolean changePassService(String pass,String changePass){
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        DailyUser dailyUser = userRepository.findByUsername(username);
        if (passwordEncoder().matches(dailyUser.getPassword(),pass)) {
            dailyUser.setPassword(changePass);
            userRepository.save(dailyUser);
            return true;
        }
        return false;
    }
}
