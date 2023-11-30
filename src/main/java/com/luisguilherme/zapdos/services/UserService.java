package com.luisguilherme.zapdos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.zapdos.dto.UserDTO;
import com.luisguilherme.zapdos.entities.Role;
import com.luisguilherme.zapdos.entities.User;
import com.luisguilherme.zapdos.projections.UserDetailsProjection;
import com.luisguilherme.zapdos.repositories.UserRepository;
import com.luisguilherme.zapdos.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
		if (result.size() == 0) {
			throw new UsernameNotFoundException("Username Not Found");
		}

		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());

		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		return user;
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
			User entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {		
		User product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado") );
		return new UserDTO(product);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
	}
}
