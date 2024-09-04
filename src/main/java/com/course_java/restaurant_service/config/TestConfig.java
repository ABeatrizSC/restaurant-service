package com.course_java.restaurant_service.config;

import com.course_java.restaurant_service.entities.User;
import com.course_java.restaurant_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") //nome do perfil de teste
public class TestConfig implements CommandLineRunner { //CommandLineRunner = interface para fazer rodar o codigo assim que a aplicação for executada

    //para fazer um objeto depender de outro (implícito):
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
