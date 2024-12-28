package com.santt4naweb.workshop01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4naweb.workshop01.entities.Order;
import com.santt4naweb.workshop01.repositories.OrderRepository;

//@Component 	// Registra a classe como componente do spring e pode ser injetado com o @Autowired
//@Repository 	// Registra um repositorio
@Service		// Registra um serviço que é o nosso caso

public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() { 	// Operação que repassa a chamada para repository findAll
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
