package com.javalatest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
class SpringBootMockitoTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloTest() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders
				.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk() )
				.andExpect((ResultMatcher) content().json("{\"id\": 1,\"name\":\"Ball\",\"quantity\":10,\"price\":100,\"value\":0}"))
				.andReturn();
		
		assertEquals("Hello from HelloController....", result.getResponse().getContentAsString());
		//assertTrue(true);
	}

}
