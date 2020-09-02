package com.voxy.wordcount.service;

public interface WordCounter {

	public static Integer count(String text) {

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
