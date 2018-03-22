package com.rs.spbwebdemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void hello() {
		String body = this.restTemplate.getForObject("/hello", String.class);
		assertThat(body).isEqualTo("Hello world!");
	}
	
	@Test
	public void goodMorning() {
		String body = this.restTemplate.getForObject("/goodMorning", String.class);
		assertThat(body).isEqualTo("Good morning!");
	}

}
