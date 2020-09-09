package com.voxy.wordcount.service;

public class WordCounterSingleton {

	private static volatile WordCounterSingleton instance = null;

	private WordCounterSingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static WordCounterSingleton getInstance() {
		if (instance == null) {
			synchronized (WordCounterSingleton.class) {
				if (instance == null) {
					instance = new WordCounterSingleton();
				}
			}
		}
		return instance;
	}

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

	public Integer countUpperCase(String text) {
		int numberOfWords = 0;
		boolean previousCharNotLetter = true;

		for (int i = 0; i < text.length(); i++) {
			if (!Character.isLetter(text.charAt(i))) {
				previousCharNotLetter = true;
			} else {
				if (previousCharNotLetter && Character.isUpperCase(text.charAt(i))) {
					numberOfWords++;
				}
				previousCharNotLetter = false;
			}
		}

		return numberOfWords;
	}

	public String returnMessage(String text) {
		return text == null || text.isEmpty() ? "Some text input is required"
				: "This text has " + count(text) + " words and " + countUpperCase(text) + " uppercase words.";
	}

}
