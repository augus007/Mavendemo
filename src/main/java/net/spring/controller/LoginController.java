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
	    String password=(String)request.getParameter("password");//ȡ��login.jsp��ֵ
	    
	    
	 // �ж�session�ǲ����´�����
	 if (session.getAttribute("java")==null) {
		 //�����ݴ洢��session��
		 if(username==null){
			 modelAndView.setViewName("login");
	  		 return modelAndView;
		 }
	 	if(username.equals("augus"))
	    {
	        if(password.equals("augus")){
	        	session.setAttribute("java", "myJavaData");
	        	session.setMaxInactiveInterval(5);
	    	 	modelAndView.addObject("message","session�����ɹ���session�ǣ�" + session.getAttribute("java"));
	        	modelAndView.setViewName("loginsuccess");
	  		  	return modelAndView;
	        }
	        else{
	        	final PrintWriter out = response.getWriter();
	            out.print("<script language='javaScript'> alert('�������');</script>");
	           modelAndView.setViewName("login");
	  		  return modelAndView;
	        }
	    }
	    else 
	    {
	    	final PrintWriter out = response.getWriter();
	        out.print("<script language='javaScript'> alert('�˺Ŵ��󡪡�else');</script>");
	      modelAndView.setViewName("login");
  		  return modelAndView;
	    }
	 	
	 } else {
	 	modelAndView.addObject("message","session�����ɹ���session�ǣ�" + session.getAttribute("java"));
	 	modelAndView.setViewName("loginsuccess");
		  	return modelAndView;
	 }

	}
	 
}
