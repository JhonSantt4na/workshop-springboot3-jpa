package com.santt4naweb.workshop01.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4naweb.workshop01.entities.User;


@RestController  // Avisando que essa classe é um recurso web implementado controlador rest
@RequestMapping(value = "/users")  // Mapeando os endpoints para que tudo que for do "User" use essa rota /user 
public class UserResource {
	
	// Criando um metodo = EbdPoint Para acessar os usuarios
	
	@GetMapping 	// Informando que é uma resposta ao GET HTTP
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com","0000-0000", "Maria123");
		return ResponseEntity.ok().body(u);
		//  ResponseEntity.ok() = Retorno com sucesso do Http +- 201
		//  .body(u); = Mandando no corpo da request o meu obj
	}
}
