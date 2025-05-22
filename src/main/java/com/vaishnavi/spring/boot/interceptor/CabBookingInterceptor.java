package com.vaishnavi.spring.boot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CabBookingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CabBookingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        logger.info("Interceptor -> preHandle(): " + request.getRequestURL() +
                " | Start Time=" + startTime);
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        logger.info("Interceptor -> postHandle(): " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        logger.info("Interceptor -> afterCompletion(): " + request.getRequestURL() +
                " | End Time=" + endTime + " | Time Taken=" + (endTime - startTime) + " ms");
    }
}


