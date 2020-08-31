package com.voxy.wordcount.model;

public class Counter {

	public Integer count(String text) {

		int numberOfWords = 0;
		boolean previousCharNotLetter = true;

		for (int i = 0; i < text.length(); i++) {
			if (!Character.isLetter(text.charAt(i))) {
				previousCharNotLetter = true;
			} else {
				if (previousCharNotLetter) {
					numberOfWords++;
				}
				previousCharNotLetter = false;
			}
		}

		return numberOfWords;
	}

}
