package com.luisguilherme.zapdos.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.luisguilherme.zapdos.entities.User;
import com.luisguilherme.zapdos.factories.TokenUtil;
import com.luisguilherme.zapdos.factories.UserFactory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Long countTotalUsers;
	private String adminToken, clientToken, invalidToken;
	private String clientUsername, adminUsername, password;
	private User user;
	private UserDTO userDTO;
	private Long existingId;
	private Long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception {

		adminUsername = "maria@gmail.com";
		clientUsername = "alex@gmail.com";
		password = "123456";
		countTotalUsers = 5L;
		existingId = 1L;
		nonExistingId = 100L;
		
		adminToken = tokenUtil.obtainAccessToken(mockMvc, adminUsername, password);
		clientToken = tokenUtil.obtainAccessToken(mockMvc, clientUsername, password);
		invalidToken = adminToken + "xpto";
		
		user = UserFactory.createUser();
		userDTO = UserFactory.createUserDTO();
	}
	
	@Test
	public void insertShouldReturnUserDTOWhenAdminLogged() throws Exception {
		
		UserDTO userDTO = UserFactory.createUserDTO();
		String jsonBody = objectMapper.writeValueAsString(userDTO);
		
		String expectedName = userDTO.getName();
		
		ResultActions result = 
				mockMvc.perform(post("/users")
					.header("Authorization", "Bearer " + adminToken)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").value(countTotalUsers+1));
		result.andExpect(jsonPath("$.name").value(expectedName));
	}
	
	@Test
	public void insertShouldReturnForbiddenWhenClientLogged() throws Exception {
		
		String jsonBody = objectMapper.writeValueAsString(userDTO);

		ResultActions result = mockMvc.perform(post("/users")
				.header("Authorization", "Bearer " + clientToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isForbidden());
	}
	
	@Test
	public void insertShouldReturnUnauthorizedWhenNotLogged() throws Exception {
		
		String jsonBody = objectMapper.writeValueAsString(userDTO);

		ResultActions result = mockMvc.perform(post("/products")
				.header("Authorization", "Bearer " + invalidToken)
				.content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void insertShouldReturnUnprocessableEntityWhenAdminLoggedAndInvalidName() throws Exception {	
				
		UserDTO userDTO = UserFactory.createUserDTO();
		
		userDTO.setName("x");
		
		String jsonBody = objectMapper.writeValueAsString(userDTO);
		
		ResultActions result = 
				mockMvc.perform(post("/users")
					.header("Authorization", "Bearer " + adminToken)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void insertShouldReturnUnprocessableEntityWhenAdminLoggedAndInvalidEmail() throws Exception {	
				
		UserDTO userDTO = UserFactory.createUserDTO();
		
		userDTO.setEmail("xxxx");
		
		String jsonBody = objectMapper.writeValueAsString(userDTO);
		
		ResultActions result = 
				mockMvc.perform(post("/users")
					.header("Authorization", "Bearer " + adminToken)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isUnprocessableEntity());
	}

	@Test
	public void insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankPassword() throws Exception {	
				
		UserDTO userDTO = UserFactory.createUserDTO();
		
		userDTO.setEmail("xxxx");
		
		String jsonBody = objectMapper.writeValueAsString(userDTO);
		
		ResultActions result = 
				mockMvc.perform(post("/users")
					.header("Authorization", "Bearer " + adminToken)
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isUnprocessableEntity());
	}
}
