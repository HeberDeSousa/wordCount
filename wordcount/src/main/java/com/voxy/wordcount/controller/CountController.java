package com.voxy.wordcount.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voxy.wordcount.service.WordCounter;

@Controller
public class CountController {

	@RequestMapping("/")
	public String countword(@RequestParam(required = false) String text, Model model, HttpServletRequest request) {
		if ("POST".equals(request.getMethod())) {
			model.addAttribute("text", text);
			if (text == null || text.equals("")) {
				model.addAttribute("result", "Some text input is required");
			} else {
				model.addAttribute("result", "This text has " + WordCounter.count(text) + " words and "
						+ WordCounter.countUpperCase(text) + " uppercase words.");
			}
		}
		return "count";
	}
	
}
