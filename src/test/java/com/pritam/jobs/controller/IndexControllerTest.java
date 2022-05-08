package com.pritam.jobs.controller;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

	@Autowired
	private IndexController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getData() throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> hm = this.restTemplate.getForObject("http://localhost:" + port + "/",
				HashMap.class);
		assertThat(hm).isNotNull();
		assertThat(hm.get("Name")).isEqualTo("Jobs App");
		assertThat(hm.get("Status")).isEqualTo("Server is Running");
		assertThat(hm.get("Date")).isInstanceOfAny(String.class);
	}
}