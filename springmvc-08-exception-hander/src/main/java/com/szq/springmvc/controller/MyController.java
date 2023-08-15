package com.szq.springmvc.controller;


import com.alibaba.fastjson.JSON;
import com.szq.springmvc.exception.AgeException;
import com.szq.springmvc.exception.MyUserException;
import com.szq.springmvc.exception.NameException;
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



    @RequestMapping(value = "/some.do",method = RequestMethod.POST)
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        System.out.println("doSome name="+name+" age="+age);
        ModelAndView mv=new ModelAndView();
        //根据请求参数抛出异常
        if (!"zs".equals(name))
        {
            throw new NameException("姓名不正确！");
        }
        if (age==null||age>80){
            throw new AgeException("年龄比较大！！！");
        }
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }



}
