package com.santt4naweb.workshop01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.santt4naweb.workshop01.entities.Category;
import com.santt4naweb.workshop01.entities.Order;
import com.santt4naweb.workshop01.entities.OrderItem;
import com.santt4naweb.workshop01.entities.Payment;
import com.santt4naweb.workshop01.entities.Product;
import com.santt4naweb.workshop01.entities.User;
import com.santt4naweb.workshop01.entities.enums.OrderStatus;
import com.santt4naweb.workshop01.repositories.CategoryRepository;
import com.santt4naweb.workshop01.repositories.OrderItemRepository;
import com.santt4naweb.workshop01.repositories.OrderRepository;
import com.santt4naweb.workshop01.repositories.ProductRepository;
import com.santt4naweb.workshop01.repositories.UserRepository;

@Configuration // Indica que a classe é uma classe de configuração do Spring
@Profile("test") // Especifica que a classe só será carregado no contexto do Spring quando o
						// perfil ativo da aplicação for "test".
public class TestConfig implements CommandLineRunner { // CommandLineRunner: Executa código ao iniciar a aplicação.O
																			// método run(String... args) contém a lógica a ser executada.

	@Autowired // Realiza a injeção de dependências automática pelo Spring,vinculando o bean
					// correspondente do contexto de aplicação Pode ser usado em atributos,
					// construtores, setters ou métodos.
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		// Código executado ao iniciar a aplicação
		// Instanciando os Usuarios
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// Instanciando o OrderStatus que foi adicionado posterior
		Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		// Instanciando a Categoria
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		// Instanciando os Products
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		// Salvando no DB
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// Logo apos Salvar no Banco vamos fazer a Manny to Manny Products to Category
		// Fazendo isso com Orientação a obj
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		// Porem quando for salvar no banco tem que ser com paradigma Relacional
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// Depois de Salvar os Pedidos Vamos instanciar os OrderItens
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		// Save in DB
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		// Adicionando um pagamento no Pedido
		Payment pay1 = new Payment(null, Instant.parse("2024-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);

		// Logo apos isso vamos mandar salva o pedido novamente
		orderRepository.save(o1);
	}

}