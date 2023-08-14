package com.it.controller;

import javax.ws.rs.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.websocket.server.PathParam;

@Controller
public class WelcomeController {

	//http://localhost:8080/msg?name=Ashok
	@RequestMapping("/msg")
	public ModelAndView message1(@QueryParam("name") String name) {
		System.out.println("Inside Message1 method");
		ModelAndView mvn=new ModelAndView();
		String msgText=name+" GoodMorning";
		mvn.addObject("msg",msgText);
	    mvn.setViewName("index");
		return mvn;
	}
	//http://localhost:8080/product?pname=Spring&author=John
	@RequestMapping("/product")
	public ModelAndView productFactory(@RequestParam String pname, String author) {
		System.out.println("Inside productFactory method");
		ModelAndView mvn=new ModelAndView();
		String msgText=author + " By "+pname +" no stock" ;
		mvn.addObject("product",msgText);
	    mvn.setViewName("index");
		return mvn;
	}
	
	//http://localhost:8080/Course/Java/AshokReddy/hyd
	@GetMapping("/Course/{lang}/{authorName}/hyd")
	public ModelAndView course(@PathVariable(value = "lang") String lang,@PathVariable String authorName) {
		System.out.println("Inside Cource method");
		ModelAndView mvn=new ModelAndView();
		String msgText=lang+" written by "+authorName ;
		System.out.println(lang+" "+authorName);
		mvn.addObject("Course",msgText);
	    mvn.setViewName("index");
		return mvn;
	}
	
	//http://localhost:8080/greet?name=ashok
	@GetMapping("/greet")
	public String getGreeting(@RequestParam String name,Model model) {
		
		model.addAttribute("msg", name+", Good Morning ...!!" );
		return "index";
	
	}
	
}
