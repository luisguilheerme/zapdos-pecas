package com.luisguilherme.zapdos.services;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luisguilherme.zapdos.dto.UserDTO;
import com.luisguilherme.zapdos.entities.User;
import com.luisguilherme.zapdos.factories.UserFactory;
import com.luisguilherme.zapdos.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;
	
	private User user;
	private UserDTO userDTO;
	
	@BeforeEach
	void setUp() throws Exception {
		
		user = UserFactory.createUser();
		userDTO = new UserDTO(user);
		
		Mockito.when(repository.save(any())).thenReturn(user);

	}
	
	@Test
	public void insertShouldReturnUserDTO() {
		
		UserDTO result = service.insert(userDTO);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), user.getId());		
	}
}
