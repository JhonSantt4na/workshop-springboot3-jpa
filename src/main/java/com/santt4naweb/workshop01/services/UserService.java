package com.santt4naweb.workshop01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.repositories.UserRepository;

//@Component 	// Registra a classe como componente do spring e pode ser injetado com o @Autowired
//@Repository 	// Registra um repositorio
@Service		// Registra um serviço que é o nosso caso

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() { 	// Operação que repassa a chamada para repository findAll
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}