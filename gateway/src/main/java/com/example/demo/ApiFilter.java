package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 服务网关还有个作用就是接口的安全性校验，
 * 这个时候我们就需要通过 zuul 进行统一拦截，
 * zuul 通过继承过滤器 ZuulFilter 进行处理
 */
@Component
public class ApiFilter extends ZuulFilter {
    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //这里写校验代码

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (!"123456".equals(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is invalid");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
