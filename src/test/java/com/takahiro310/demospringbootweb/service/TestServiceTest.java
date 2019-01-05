package com.takahiro310.demospringbootweb.service;



import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.takahiro310.demospringbootweb.domain.TestBean;

@SpringBootTest
public class TestServiceTest {

	@Autowired
	private TestService testService;

	@Test
	public void dataFound() {
		Optional<TestBean> opt = testService.findByName("dog");
		assertEquals(opt.isPresent(), true);
	}

	@Test
	public void dataNotFound() {
		Optional<TestBean> opt = testService.findByName("");
		assertEquals(opt.isPresent(), false);
	}
}
