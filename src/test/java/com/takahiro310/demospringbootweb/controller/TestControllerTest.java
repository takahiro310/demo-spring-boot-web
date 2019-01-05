package com.takahiro310.demospringbootweb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.takahiro310.demospringbootweb.service.TestService;

@WebMvcTest(TestController.class)
public class TestControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@MockBean
	private TestService testService;

	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/test/list"))
			.andExpect(status().isOk())
			.andExpect(view().name("test-list"));
	}
}
