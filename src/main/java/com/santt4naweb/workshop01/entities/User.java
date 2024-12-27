package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity  //Declara que a classe é uma entidade JPA (Java Persistence API). Isso significa que ela será mapeada para uma tabela no banco de dados.
@Table(name = "tb_user") // Especifica o nome da tabela no banco de dados que será associada à entidade.
public class User implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	@Id // Define o atributo como a chave primária da tabela.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o valor da chave primária será gerado automaticamente pelo banco de dados. 
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	public User() {   
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
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
	
}
