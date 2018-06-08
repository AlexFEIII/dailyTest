package com.pro.daily.dailyConfig;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

class ResponseObject{
    private String status;
    private String msg;
    public ResponseObject(String msg,String status){
        this.msg = msg;
        this.status = status;
    }
    public String getMsg(){
        return msg;
    }
    public String getStatus(){
        return status;
    }
}

public class LoginFailure extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
//        System.out.println("登陆失败");
//        JSONObject returnObj = new JSONObject();
//        returnObj.put("status", "400");
//        returnObj.put("data", "用户名不存在");
//        response.getWriter().print(returnObj.toString());
//        response.getWriter().flush();
//        System.out.println("登陆失败");
//        String ajaxHeader = request.getHeader("X-Requested-With");
//        System.out.println(ajaxHeader);
//        boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);
//        System.out.println(isAjax);
//        if (isAjax) {
//            JSONObject returnObj = new JSONObject();
//            returnObj.put("status", "400");
//            returnObj.put("data", exception.getMessage());
//            response.getWriter().print(returnObj.toString());
//            response.getWriter().flush();
//        } else {
//            super.onAuthenticationFailure(request, response, exception);
//        }
        System.out.println("登陆失败！~！~！~");
        /*
        * 可以通过返回的异常信息不同给前端返回不同的信息
        * 具体看捕捉的异常
        * */
        System.out.println("异常信息： "+exception.getMessage());
        ResponseObject r = new ResponseObject("fail","no");
        String msg = JSON.toJSONString(r);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(msg);
        response.getWriter().flush();
    }

}