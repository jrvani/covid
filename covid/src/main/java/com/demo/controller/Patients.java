package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Patients {
	
	
	@GetMapping(value="/loadAddPatients")
	public ModelAndView load()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("addPatients");
		return modelAndView;
	}
	
	@PostMapping(value="/addPatients")
	public ModelAndView addPatients(@RequestParam("name") String name,@RequestParam("age") String age,HttpSession session)
	{
	
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("username", name);
		//int n=validation.verifyUser(username, password);
		
		modelAndView.setViewName("success");
		

		return modelAndView;
	}
    

}
