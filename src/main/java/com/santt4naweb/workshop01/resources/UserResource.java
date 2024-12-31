package com.santt4naweb.workshop01.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // Indicando que vai aceitar um parametro na url
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	// PostMapping = para associar a uma requisição POST
	// @RequestBody = para dizer que o user vem no corpo da requisição
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);

		// Criação e Explicação da Construção da uri

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// ServletUriComponentsBuilder.fromCurrentRequest() = Cria um builder baseado na
		// URL da requisição atual.
		// Por exemplo, se a requisição foi feita para http://localhost:8080/users, essa
		// será a URL base.

		// .path("/{id}") = Aqui, estamos adicionando /{id} ao final da URL base URL se
		// tornaria http://localhost:8080/users/{id}

		// .buildAndExpand(obj.getId()) = Substitui os valores dinâmicos no caminho
		// (como {id}) por valores reais.
		// O obj.getId() retorna o ID do objeto recém-criado e substitui o {id}. xemplo:
		// Se obj.getId() retorna 123, a URL agora é http://localhost:8080/users/123

		// .toUri() = Converte o caminho construído em um objeto do tipo URI Esse objeto
		// é usado para ser retornado como parte do cabeçalho Location em uma resposta
		// HTTP

		// Ao inves de usar esse comando:
		// return ResponseEntity.ok().body(obj); Ussamos esse porem o Created
		// espera um uri que é um cabeçario chamado location, contendo o
		// endereço do nosso item criado.
		return ResponseEntity.created(uri).body(obj);
	}

}