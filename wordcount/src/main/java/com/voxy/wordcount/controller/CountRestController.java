package com.voxy.wordcount.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voxy.wordcount.service.WordCounter;

@RestController
public class CountRestController {

	@PostMapping("/ajax")
	public String countAjax(@RequestParam String text) {
		if (text == null || text.equals("")) {
			return "Some text input is required";
		} else {
			return "This text has " + WordCounter.count(text) + " words and " + WordCounter.countUpperCase(text)
					+ " uppercase words.";
		}
	}

}
