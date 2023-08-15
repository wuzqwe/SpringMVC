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
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/return.do",method = RequestMethod.POST)
    public String doReturnView(HttpServletRequest request,String name,Integer age){
        System.out.println("doReturnView name="+name+" age="+age);
        //可以自己手动添加数据到request作业域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        //show:逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作

        return "show";
    }

    /**
     * returnVoid.do
     *处理器方法返回void，响应ajax请求
     */
    @RequestMapping(value = "/returnVoid.do ")
    public void doReturnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {
        System.out.println("doReturnVoidAjax name="+name+" age="+age);
        //处理ajax，使用json做数据格式
        //service调用完成了，使用Studnet表示处理结果
        Student student=new Student(name,age);
        //将结果转化成JSON格式
        String json = JSON.toJSONString(student);
        System.out.println(json);


        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 处理器方法返回一个Student，通过框架转为JSON，响应ajax请求
     * @ResponseBody
     *  作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器4
     *  位置:方法定义上面。和其他注解没有顺序关系
     *  返回对象框架的处理流程
     *  1.框架会把返回Student类型，调用框架中ArrayList<HttpMessageConverter>中每个类中canWrite()方法
     *  检查那个HttpMessageConverter接口的实现类能处理Student类型的数据
     *  2.框架会调用实现类的write（），MappingJackson2HttpMessageConverter的write()方法
     *  把李四的Student对象转为json,调用jackson的ObjectMapper实现转为json
     *  3.框架会调用@ResponseBody把2的结果输出到浏览器，ajax请求完成
     */

    @RequestMapping(value = "/requestStudent.do")
    @ResponseBody
    public Student doStudent(String name,Integer age){
        //调用service，获取请求数据，Student表示结果数据
        Student student = new Student();
        student.setAge(age);
        student.setName(name);

//        System.out.println(student);

        return student;//会被框架转为json
    }

    /**
     * 处理器方法返回的是List<Student>
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/requestStudentArray.do")
    @ResponseBody
    public List<Student> doStudentArray(String name, Integer age){

        List<Student> list=new ArrayList<>();
        //调用service，获取请求数据，Student表示结果数据
        Student student = new Student();
        student.setAge(20);
        student.setName("李四");
        list.add(student);
        Student student1 = new Student();
        student1.setAge(18);
        student1.setName("张三");
        list.add(student1);
//        System.out.println(student);

        return list;//会被框架转为json
    }

    /**
     * 处理器方法返回的是String，String表示数据的，表示视图
     * 区分返回值String是视图还是数据，看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回String就是数据，反之就是视图
     *
     *
     * 默认使用text/plain;charset=ISO-8859-1作为contentType，导致中文有乱码
     * 解决方案：给RequestMapping增加一个属性produces,使用这个属性指定新的contentType
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }

}
