package com.pro.daily.dailyService.impl;

        import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
        import com.pro.daily.domain.DailyUserPackage.DailyUser;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.authentication.BadCredentialsException;
        import org.springframework.security.core.authority.AuthorityUtils;
        import org.springframework.security.core.userdetails.*;
        import org.springframework.stereotype.Component;

//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;

@Component
public class LoginServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        System.out.println("username:"+username);
        System.out.println("username:"+username);
        System.out.println("username:"+username);
        try{
            DailyUser user = userRepository.findByUsername(username);
            System.out.println("user:"+user.getUsername());
            return new User(user.getUsername(),user.getPassword(),AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
        }catch (Exception e){
            throw new BadCredentialsException("用户名不存在");
        }
    }
}
//public class LoginServiceImpl implements AuthenticationProvider{
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName();
//        String pass = (String)authentication.getCredentials();
//        System.out.println(name + "  " +pass);
//        if(name.equals("admin") && pass.equals("123456"))
//            return new UsernamePasswordAuthenticationToken(authentication,778899);
//        throw new BadCredentialsException("authError");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}
