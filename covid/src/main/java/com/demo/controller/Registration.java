package com.demo.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dto.UserDTO;
import com.demo.exceptions.ListNotFound;
import com.demo.service.Validation;

@Controller

public class Registration {
	@Autowired
	Validation validation;
	
	@GetMapping("load")
	public ModelAndView loadRegistartion() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("instructorDto", new UserDTO());
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	
	@PostMapping(value="register")
	public ModelAndView register(@Valid @ModelAttribute("instructorDto") UserDTO instructorDto,BindingResult result) throws ListNotFound
	{
		ModelAndView mv=new ModelAndView();
		
	    if(validation.register(instructorDto)) {
			mv.setViewName("login");
			
			
		
				
	    }
	    else if(result.hasErrors()) {
			    	mv.setViewName("registration");
				}
		else {
				mv.setViewName("registration");
			}
			
		
			
		return mv;
	}
	
	

}
