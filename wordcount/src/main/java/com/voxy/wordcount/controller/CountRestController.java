package com.voxy.wordcount.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voxy.wordcount.service.WordCounterSingleton;

@RestController
public class CountRestController {

	@PostMapping("/ajax")
	public String countAjax(@RequestParam String text) {
		//Lazy loading. Only initalized when needed
		WordCounterSingleton counter = WordCounterSingleton.getInstance();
		return counter.returnMessage(text);
	}

}
