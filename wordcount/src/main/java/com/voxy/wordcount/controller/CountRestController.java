package com.voxy.wordcount.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voxy.wordcount.service.WordCounterSingleton;

@RestController
public class CountRestController {
	
	WordCounterSingleton counter = WordCounterSingleton.getInstance();

	@PostMapping("/ajax")
	public String countAjax(@RequestParam String text) {
		return counter.returnMessage(text);
	}

}
