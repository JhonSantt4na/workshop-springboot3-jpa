package com.santt4naweb.workshop01.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.repositories.UserRepository;

@Configuration // Indica que a classe é uma classe de configuração do Spring
@Profile("test") // Especifica que a classe só será carregado no contexto do Spring quando o perfil ativo da aplicação for "test".
public class TestConfig implements CommandLineRunner{ // CommandLineRunner: Executa código ao iniciar a aplicação.O método run(String... args) contém a lógica a ser executada.
	
	@Autowired //  Realiza a injeção de dependências automática pelo Spring,vinculando o bean correspondente do contexto de aplicação Pode ser usado em atributos, construtores, setters ou métodos.
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// Código executado ao iniciar a aplicação
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// Salvando no DB
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}