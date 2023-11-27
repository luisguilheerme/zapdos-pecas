package com.luisguilherme.zapdos.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisguilherme.zapdos.dto.UserDTO;
import com.luisguilherme.zapdos.factories.UserFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Long countTotalUsers;
	
	@BeforeEach
	void setUp() throws Exception {

		countTotalUsers = 5L;
	}
	
	@Test
	public void insertShouldReturnUserDTO() throws Exception {
		
		UserDTO userDTO = UserFactory.createUserDTO();
		String jsonBody = objectMapper.writeValueAsString(userDTO);
		
		String expectedName = userDTO.getName();
		
		ResultActions result = 
				mockMvc.perform(post("/users")
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").value(countTotalUsers+1));
		result.andExpect(jsonPath("$.name").value(expectedName));
	}
}
