package com.voxy.wordcount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountController {
	
	@RequestMapping("/")
	public String countword(@RequestParam(required = false) String text, Model model) {
		model.addAttribute("result", text);
		return "count";
	}

}
