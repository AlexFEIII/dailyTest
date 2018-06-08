package com.pro.daily.dailyConfig;

        import com.alibaba.fastjson.JSON;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class LoginSuccess extends SimpleUrlAuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        System.out.println("登陆成功");
        SuccessResponse s = new SuccessResponse("TRUE","success");
        response.setContentType("application/json;charset=utf-8");
        String msg = JSON.toJSONString(s);
        System.out.println("mag: "+msg);
        response.getWriter().print(msg);
        response.getWriter().flush();
    }
}
class SuccessResponse{
    private String status;
    private String msg;
    public SuccessResponse(){}
    public SuccessResponse(String status,String msg){
        this.status = status;
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
    public String getStatus(){
        return status;
    }
}
