package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.util.Objects;

// Passo a Passo 
// Forma Convencional de Criar as Entities (Entidades)

public class User implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	// Passo 1: Atributos
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	// Passo 2: Associações
	//		(Como é a primeira Classe não temos)

	// Passo 3: Construtores
	
	public User() {   //  ( Obrigado )	
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	// Passo 4: Getters e Setters
	//( Lembrando que as Collections teram somente os Getters )
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Passo 5: hashCode e equals
	//  Normalmente usamos o id para comparação porem depende da aplicação
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	// Passo 6: Serializable
	// Adiciona na Classe "implements Serializable"
	
	// (Interface para que esses objetos sejam transformados em cadeias de bytes
	// Para que esse obj possa ser trafegado pela rede, ou que possa ser gravado em arquivos etc..)
	
	// Logo em seguida importamos o Serializable e o seu numero de serie
	
	// import = import java.io.Serializable;
	// Num. Serie = private static final long serialVersionUID = 1l;
	
}
