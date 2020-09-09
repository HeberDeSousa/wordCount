package com.voxy.wordcount.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voxy.wordcount.service.WordCounterSingleton;

@Controller
public class CountController {
	
	WordCounterSingleton counter = WordCounterSingleton.getInstance();

	@RequestMapping("/")
	public String countword(@RequestParam(required = false) String text, Model model, HttpServletRequest request) {
		if ("POST".equals(request.getMethod())) {
			model.addAttribute("text", text);		
            model.addAttribute("result", counter.returnMessage(text));
		}
		return "count";
	}

}
