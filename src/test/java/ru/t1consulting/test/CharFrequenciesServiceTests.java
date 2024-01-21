package ru.t1consulting.test;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Map;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CharFrequenciesServiceTests {

	private final CharFrequenciesService charFrequenciesService;

	@Test
	void emptyStringTest() {
		String str = "";
		Assertions.assertEquals(Collections.emptyMap(),
				charFrequenciesService.getCharFrequencies(str),
				"Возвращается не пустой список");
	}

	@Test
	void blankStringTest() {
		String str = "  ";
		Assertions.assertEquals(Collections.emptyMap(),
				charFrequenciesService.getCharFrequencies(str),
				"Возвращается не пустой список");
	}

	@Test
	void usualStringTest() {
		String str = "aaaaabcccc";
		Map<Character,Integer> expected = Map.of(
				'a', 5,
				'c', 4,
				'b', 1);

		Assertions.assertEquals(expected,
				charFrequenciesService.getCharFrequencies(str),
				"Списки не соответствуют");
	}

}
