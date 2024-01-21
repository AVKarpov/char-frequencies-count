package ru.t1consulting.test;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CharFrequenciesControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void emptyStringTest() throws Exception {
		String requestBody = "";
		mvc.perform(MockMvcRequestBuilders.get("/frequencies")
					.contentType("text/plain")
					.content(requestBody))
			.andExpect(status().isBadRequest());
	}

	@Test
	void usualStringTest() throws Exception {
		String requestBody = "aaaaabcccc";

		mvc.perform(MockMvcRequestBuilders.get("/frequencies")
						.contentType("text/plain")
						.content(requestBody))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.a", is(5)))
				.andExpect(jsonPath("$.c", is(4)))
				.andExpect(jsonPath("$.b", is(1)));
	}

}
