package com.course_java.restaurant_service.config;

import com.course_java.restaurant_service.entities.*;
import com.course_java.restaurant_service.entities.enums.OrderStatus;
import com.course_java.restaurant_service.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") //nome do perfil de teste
public class TestConfig implements CommandLineRunner { //CommandLineRunner = interface para fazer rodar o codigo assim que a aplicação for executada

    //para fazer um objeto depender de outro (implícito):
    @Autowired
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
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product produto1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product produto2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product produto3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product produto4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product produto5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

        //Relação de objetos - adicionado categorias a um produto
        produto1.getCategories().add(cat2);
        produto2.getCategories().add(cat1);
        produto2.getCategories().add(cat3);
        produto3.getCategories().add(cat3);
        produto4.getCategories().add(cat3);
        produto5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

        User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User usuario2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, usuario1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, usuario2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, usuario1);

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem orderItem1 = new OrderItem(order1, produto1, 2, produto1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, produto3, 1, produto3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, produto3, 2, produto3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, produto5, 2, produto5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
    }
}
