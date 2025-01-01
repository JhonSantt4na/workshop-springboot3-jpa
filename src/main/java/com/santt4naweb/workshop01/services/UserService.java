package com.santt4naweb.workshop01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.repositories.UserRepository;

//@Component 	// Registra a classe como componente do spring e pode ser injetado com o @Autowired
//@Repository 	// Registra um repositorio
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	// Inserindo Usuario
	public User insert(User obj) {
		return repository.save(obj);
	}

	// Deletando um Usuario
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// Atualizando um Usuario
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); // Deixa um obj monitorado sem ir pra o banco ainda
		// Melhor que o getbyid pois o precisa ir no banco o byid
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
