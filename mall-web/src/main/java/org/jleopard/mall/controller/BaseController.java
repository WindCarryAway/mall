package org.jleopard.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Copyright (c) 2018, Chen_9g 陈刚 (80588183@qq.com).
 * @DateTime 2018/7/20
 *
 * <p>
 * Find a way for success and not make excuses for failure.
 * </p>
 */
@Controller
public class BaseController {

    /**
     * 得到ModelAndView
     */
    protected  ModelAndView getModelAndView(String viewName) {

        ModelAndView mv = new ModelAndView(viewName);

        String context = getRequest().getContextPath();

        String path=getRequest().getRequestURI();

        mv.addObject("ctx", context);

        mv.addObject("uri", path.substring(context.length()));

        return mv;
    }

    protected ModelAndView redirectModelAndView(String viewName) {

        ModelAndView mv = getModelAndView("redirect:/"+viewName);

        return mv;
    }

   /* public ModelAndView getObjectExcelView(Map<String,Object> dataMap) {

        ObjectExcelView erv = new ObjectExcelView();

        ModelAndView mv = new ModelAndView(erv,dataMap);

        return mv;
    }*/


    /**
     * 得到request对象
     */
    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }

    /**
     * 得到request对象
     */
    protected HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        return request.getSession();
    }

}
