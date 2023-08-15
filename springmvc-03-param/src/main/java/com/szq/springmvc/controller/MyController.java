package com.szq.springmvc.controller;


import com.szq.springmvc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * 逐个接收请求参数：
     * 要求：处理器方法的形参名和请求中参数名必须一致
     * 同名的请求参数赋值给同名的形参
     *
     *
     * 框架接收请求参数
     * 1.使用request对象接收请求参数
     * String strName=request.getParameter("name");
     * String strAge=request.getParameter("age");
     * 2.springmvc框架通过DispatcherServlet调用MyController的doSome()
     * 调用方法时，按名称对应，吧接收的参数赋值给形参
     * doSome(strName,Integer.valueof(strAge))
     * 框架会提供类型转换的功能，能把String字符串
     * @return
     */


    /**
     * 请求中参数名和处理器方法形参名不一样
     * @RequestParam:解决请求中参数名形参名不一样的问题
     * 属性：1.value 请求中的参数的名称
     *      2.required 是一个boolean,默认是true
     *      true:表示请求中必须包含此参数
     * 位置：2.在处理器方法的形参定义的前面
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(@RequestParam(value = "rname") String name,
                                @RequestParam(value = "rage",required = false) Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",name);
        mv.addObject("fun",age);
        mv.setViewName("other");
        return mv;
    }


    /**
     * 处理器方法形参是java对象，这个对象的属性名和请求中参数名一样
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/from.do",method = RequestMethod.POST)
    public ModelAndView doFrom(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",student.getName());
        mv.addObject("fun",student.getAge());
        mv.addObject("student",student);
        mv.setViewName("other");
        return mv;
    }


}
