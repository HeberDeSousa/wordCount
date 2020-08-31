package com.voxy.wordcount.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voxy.wordcount.service.Counter;

@Controller
public class CountController {

	@RequestMapping("/")
	public String countword(@RequestParam(required = false) String text, Model model, HttpServletRequest request) {
		if (request.getMethod().compareToIgnoreCase("POST") == 0) {
			model.addAttribute("text", text);
			if (text == null || text.trim().equals("")) {
				model.addAttribute("result", "Some text input is required");
			} else {
				model.addAttribute("result", "This text has " + Counter.count(text) + " words.");
			}
		}
		return "count";
	}

}
