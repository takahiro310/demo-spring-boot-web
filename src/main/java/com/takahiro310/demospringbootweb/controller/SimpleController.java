package com.takahiro310.demospringbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

	@RequestMapping("/simple01")
	public String simple01() {
		return "simple01";
	}

	@RequestMapping("/simple02/{userId}")
	public ModelAndView test(@PathVariable("userId") String userId, ModelAndView mav) {
		mav.addObject("model", "model");
	    mav.setViewName("simple02");
	    return mav;
	}

}
