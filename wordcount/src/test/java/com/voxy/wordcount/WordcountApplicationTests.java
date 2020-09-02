package com.voxy.wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.voxy.wordcount.service.WordCounter;

@SpringBootTest
class WordcountApplicationTests {

	@Test
	void countSingleWord() {
		assertEquals(1, WordCounter.count("text"));
	}
	
	@Test
	void countTwoWords() {
		assertEquals(2, WordCounter.count("text here!"));
	}

	@Test
	void countSingleWordWithSpaces() {
		assertEquals(1, WordCounter.count("   text "));
	}

	@Test
	void countFourWordsWithPunctuation() {
		assertEquals(4, WordCounter.count(" this, is!  text. that "));
	}

	@Test
	void countTextWithNewLine() {
		assertEquals(12, WordCounter.count("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n"
				+ "Phasellus dapibus viverra auctor. \n" + ""));
	}

}
