//package com.pro.daily.dailyConfig;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class LoginSuccessConfig extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws ServletException,IOException{
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().println("{\"username\":\"XiaoMing\",\"role\":\"USER\"");
//    }
//}