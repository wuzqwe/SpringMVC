package com.szq.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 创建处理器对象，对象放到springmvc容器中
*
* 能处理请求的控制器（处理器）：MyController能处理请求
* 叫做后端控制器（back controller）
* */
@Controller
@RequestMapping("/user")
public class MyController {
    //处理请求
    /*
    * 准备使用doSome方法处理some.do请求
    * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定一起
    * 一个请求指定一个方法处理
    * 属性：value是一个String,表示请求的url地址(some.do)
    * value的值必须是唯一的，不能重复。在使用时推荐地址以"/"
    * 位置：1.在方法的上面，常用的
    * 2.在类的上面
    * 说明:使用@RequestMapping修饰的方法叫做处理器方法或者控制器方法
    * 使用@RequestMapping修饰的方法可以处理请求的，类似Servlet中的doGet,doPost
    *
    * 返回值：ModelAndView 表示本次请求的处理结果
    * Model:数据，请求处理完成，要显示给用户的数据
    * View:视图，比如jsp等等
    **/


    /**
     * @RequestMapping：请求映射
     * 属性：method,表示请求的方式。它的值RequestMethod类枚举值
     * 例如表示get请求方式，RequestMethod.GET
     * post方式，RequestMethod.POST
     * @return
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //处理some.do的请求了
        ModelAndView mv=new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域
        //request.setAttribute("msg","欢迎使用springmvc做web开发")
        mv.addObject("msg","欢迎使用springmvc做web开发"+request.getParameter("name"));
        mv.addObject("fun","执行的是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show.jsp").forward(...)
//        mv.setViewName("/show.jsp");
//        mv.setViewName("/WEB-INF/view/show.jsp");

        //当配置了视图解析器，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀+逻辑名称+后缀组成完成路径，这里就是字符串连接操作
        mv.setViewName("show");

        return mv;
    }

    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","===欢迎使用springmvc");
        mv.addObject("fun","执行的是doOther");
        mv.setViewName("other");
        return mv;
    }


}
