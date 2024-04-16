package com.huike.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.http.protocol.RequestContent;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class LoginFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //3.获取请求参数access-token
        String token = request.getParameter("access-token");
        if (token == null) {
            //4.1 如果token==null ,拦截请求,返回认证失败
            ctx.setSendZuulResponse(false); // 拦截请求
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        //4.2 如果token!=null ,继续后续操作
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
