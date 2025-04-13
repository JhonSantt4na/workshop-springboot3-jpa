# 🛒 Workshop01 - Sistema de Pedidos com Spring Boot

![Java](https://img.shields.io/badge/Java-17+-red?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7+-brightgreen?style=for-the-badge&logo=springboot)
![License](https://img.shields.io/github/license/JhonSantt4na/workshop01?style=for-the-badge)
![Status](https://img.shields.io/badge/status-Concluido-green?style=for-the-badge)
![Last Commit](https://img.shields.io/github/last-commit/JhonSantt4na/workshop01?style=for-the-badge)

> Sistema backend de pedidos (e-commerce simples) desenvolvido com Java + Spring Boot, focado no aprendizado de entidades relacionais com JPA/Hibernate.

---

## 🚀 Tecnologias utilizadas

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Data JPA
- ✅ H2 Database
- ✅ Maven
- ✅ Postman (testes manuais)

---

## 📦 Entidades do sistema

| Entidade    | Relacionamentos | Campos principais                  |
|-------------|------------------|------------------------------------|
| `User`      | 1:N com `Order`  | `id`, `name`, `email`, `phone`, `password` |
| `Order`     | N:1 com `User`, 1:1 com `Payment`, 1:N com `OrderItem` | `id`, `moment`, `status` |
| `OrderItem` | N:1 com `Order` e `Product` | `quantity`, `price` |
| `Payment`   | 1:1 com `Order` (`@MapsId`) | `id`, `moment` |
| `Product`   | N:M com `Category`, 1:N com `OrderItem` | `id`, `name`, `price`, `imgUrl` |
| `Category`  | N:M com `Product` | `id`, `name` |

---
## 🧪 Como rodar localmente

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/workshop01.git
   cd workshop01

    Abra no IntelliJ/VSCode

    Execute a aplicação

        Via terminal:

        ./mvnw spring-boot:run

        Ou execute Workshop01Application.java

    Acesse o H2 Console

        http://localhost:8080/h2-console

        JDBC URL: jdbc:h2:mem:testdb

    Testar endpoints no Postman

        GET /users

        GET /orders

        GET /products

        GET /categories

✅ Funcionalidades implementadas

    🔎 Listagem de usuários, produtos, categorias e pedidos

    💰 Cálculo automático do subtotal e total do pedido

    🔁 Associação entre pedidos, produtos e pagamentos

    🧩 Relacionamentos complexos com JPA (OneToMany, ManyToMany, OneToOne)

📚 Aprendizados

    Modelagem de domínio com foco em relacionamentos reais

    Uso de @EmbeddedId e chave composta

    Serialização correta com @JsonIgnore para evitar loops infinitos

    Entendimento profundo da anotação @MapsId

📌 Autor

Desenvolvido com 💻 por Santt4na
📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

---
