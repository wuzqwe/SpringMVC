package com.szq.springmvc.controller;


import com.alibaba.fastjson.JSON;
import com.szq.springmvc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/*
* 创建处理器对象，对象放到springmvc容器中
*
* 能处理请求的控制器（处理器）：MyController能处理请求
* 叫做后端控制器（back controller）
* */
@Controller
public class MyController {


    /**
     * 处理器方法返回ModelAndView,实现转发forward
     * 语法：setViewName("forward:视图文件完整路径")
     * 特点：不和视图解析器一同使用，就当项目中没有视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/doForward.do",method = RequestMethod.POST)
    public ModelAndView doSome(String name,Integer age){
        System.out.println("doSome name="+name+" age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }


    /**
     * 处理器方法返回ModelAndView,实现重定向redirect
     * 语法：setViewName("redirect:视图完整路径")
     * 特点：不和视图解析器一同使用，就当项目中没有视图解析器
     *
     * 重定向不能访问/WEB-INF资源
     * @param name
     * @param age
     * @return
     */

    @RequestMapping(value = "/doRedirect.do",method = RequestMethod.POST)
    public ModelAndView doRedirect(String name,Integer age){
        System.out.println("doSome name="+name+" age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //重定向
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }



}
