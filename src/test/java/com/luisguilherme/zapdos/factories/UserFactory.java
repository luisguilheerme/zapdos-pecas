package com.luisguilherme.zapdos.factories;

import com.luisguilherme.zapdos.dto.UserDTO;
import com.luisguilherme.zapdos.entities.User;

public class UserFactory {

	public static User createUser() {
		User user = new User(1L, "Antonio", "antonio@gmail.com", "123");
		return user;
	}
	
	public static UserDTO createUserDTO() {
		User user = createUser();
		return new UserDTO(user);
	}
	
}
