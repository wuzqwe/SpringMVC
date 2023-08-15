package com.szq.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/*
* 创建处理器对象，对象放到springmvc容器中
*
* 能处理请求的控制器（处理器）：MyController能处理请求
* 叫做后端控制器（back controller）
* */
@Controller
public class MyController {

    @RequestMapping(value = "/some.do",method = RequestMethod.POST)
    public ModelAndView doSome(String name,Integer age){
        System.out.println("====执行MyController中的doSome方法");
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping("/s.do")
    @ResponseBody
    public String ss(){
        return "你好skd";
    }


}
