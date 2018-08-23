package net.spring.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class LoginController {
	
	@RequestMapping("logincheck")
	public ModelAndView test2(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		
	    request.setCharacterEncoding("UTF-8");
	    String username=(String)request.getParameter("username");
	    String password=(String)request.getParameter("password");//取出login.jsp的值
	    
	    
	 // 判断session是不是新创建的
	 if (session.getAttribute("java")==null) {
		 //将数据存储到session中
		 if(username==null){
			 modelAndView.setViewName("login");
	  		 return modelAndView;
		 }
	 	if(username.equals("augus"))
	    {
	        if(password.equals("augus")){
	        	session.setAttribute("java", "myJavaData");
	        	session.setMaxInactiveInterval(5);
	    	 	modelAndView.addObject("message","session创建成功，session是：" + session.getAttribute("java"));
	        	modelAndView.setViewName("loginsuccess");
	  		  	return modelAndView;
	        }
	        else{
	        	final PrintWriter out = response.getWriter();
	            out.print("<script language='javaScript'> alert('密码错误');</script>");
	           modelAndView.setViewName("login");
	  		  return modelAndView;
	        }
	    }
	    else 
	    {
	    	final PrintWriter out = response.getWriter();
	        out.print("<script language='javaScript'> alert('账号错误——else');</script>");
	      modelAndView.setViewName("login");
  		  return modelAndView;
	    }
	 	
	 } else {
	 	modelAndView.addObject("message","session创建成功，session是：" + session.getAttribute("java"));
	 	modelAndView.setViewName("loginsuccess");
		  	return modelAndView;
	 }

	}
	 
}
