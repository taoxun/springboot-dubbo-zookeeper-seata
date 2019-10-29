package com.viewscenes.common.interceptor;

import cn.hutool.core.lang.Snowflake;
import com.viewscenes.common.constant.Constant;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TraceIdInterceptor implements HandlerInterceptor {

    Snowflake snowflake = new Snowflake(1,0);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        MDC.put(Constant.TRACEID,snowflake.nextIdStr());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        MDC.remove(Constant.TRACEID);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){}
}
