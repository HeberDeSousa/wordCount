package com.voxy.wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.voxy.wordcount.model.Counter;

@SpringBootTest
class WordcountApplicationTests {

	Counter counter;

	{
		counter = new Counter();
	}

	@Test
	void countSingleWord() {
		assertEquals(1, counter.count("text"));
	}
	
	@Test
	void countTwoWords() {
		assertEquals(2, counter.count("text here!"));
	}

	@Test
	void countSingleWordWithSpaces() {
		assertEquals(1, counter.count("   text "));
	}

	@Test
	void countFourWordsWithPunctuation() {
		assertEquals(4, counter.count(" this, is!  text. that "));
	}

	@Test
	void countTextWithNewLine() {
		assertEquals(12, counter.count("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n"
				+ "Phasellus dapibus viverra auctor. \n" + ""));
	}

}
