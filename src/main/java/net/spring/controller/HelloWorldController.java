package net.spring.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
	 
	@Controller 
	public class HelloWorldController {
	 
	 @RequestMapping("login")  //RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
	 public ModelAndView helloWorld() {
	 
	  String me = "Hello World, Spring 3.0!";
	  //ModelAndView： 包含了试图要实现的模型数据和逻辑视图名
	  //message 为数据的名称，在视图中用来引用的名字
	  //me 是对应的值
	  //hello 是对应视图的名字。
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.addObject("message", me);
	  modelAndView.setViewName("login");
	  return modelAndView;
	  
	  //以上4个语句相当于一下一句：
	  //return new ModelAndView("hello","message",me);
	 }

}
