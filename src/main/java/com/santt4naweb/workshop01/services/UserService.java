package com.santt4naweb.workshop01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.repositories.UserRepository;
import com.santt4naweb.workshop01.services.exception.DatabaseException;
import com.santt4naweb.workshop01.services.exception.ResourceNotFoundException;

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
		// return obj.get(); // da aquela exception
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // tenta da o get se não conseguir lança uma
																								// exception do tipo informado
	}

	// Inserindo Usuario
	public User insert(User obj) {
		return repository.save(obj);
	}

	// Deletando um Usuario
	public void delete(Long id) {
		// Para passa o erro + mostra o erro que passamos

		// catch (RuntimeException e) { // Captura qualquer Exception na execução
		// e.printStackTrace(); // Lança um texto com a Exception que aconteceu

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) { // Capturando a Exception deletar user com id q n tem
			throw new ResourceNotFoundException(id); // Lançando a Exception de serviço
		} catch (DataIntegrityViolationException e) { // Capturando Tenta deletar user com pedidos associado
			throw new DatabaseException(e.getMessage()); // Lançando minha Exception
		}
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
