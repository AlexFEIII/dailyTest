package com.pro.daily.dailyConfig;

import com.pro.daily.dailyService.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){return  new BCryptPasswordEncoder();}

    @Bean
    public LoginServiceImpl loginService(){return new LoginServiceImpl();}

    @Bean
    public SimpleUrlAuthenticationFailureHandler loginFailure(){
        LoginFailure loginFailure = new LoginFailure();
        return loginFailure;
    }

    @Bean
    public SimpleUrlAuthenticationSuccessHandler loginSuccess(){
        LoginSuccess loginSuccess = new LoginSuccess();
        return loginSuccess;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
//                .antMatchers("/login").permitAll()
                .antMatchers("/changePass").fullyAuthenticated()
                .antMatchers("/manage").hasAnyRole("ROLE_MANAGE","ROLE_EDITOR")
                .anyRequest().permitAll()
                .and().csrf().disable()
                .formLogin().loginProcessingUrl("/login").successHandler(loginSuccess())
                .failureHandler(loginFailure())
        .and().rememberMe().tokenValiditySeconds(60*60*24*7).and().sessionManagement().invalidSessionUrl("/index.html").maximumSessions(1).expiredUrl("/index.html");
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(loginService()).passwordEncoder(passwordEncoder());
    }
}
