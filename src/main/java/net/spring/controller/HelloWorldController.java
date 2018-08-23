package net.spring.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
	 
	@Controller 
	public class HelloWorldController {
	 
	 @RequestMapping("login")  //RequestMapping��һ���������������ַӳ���ע�⣬��������򷽷��ϡ��������ϣ���ʾ���е�������Ӧ����ķ��������Ըõ�ַ��Ϊ��·��
	 public ModelAndView helloWorld() {
	 
	  String me = "Hello World, Spring 3.0!";
	  //ModelAndView�� ��������ͼҪʵ�ֵ�ģ�����ݺ��߼���ͼ��
	  //message Ϊ���ݵ����ƣ�����ͼ���������õ�����
	  //me �Ƕ�Ӧ��ֵ
	  //hello �Ƕ�Ӧ��ͼ�����֡�
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.addObject("message", me);
	  modelAndView.setViewName("login");
	  return modelAndView;
	  
	  //����4������൱��һ��һ�䣺
	  //return new ModelAndView("hello","message",me);
	 }

}
