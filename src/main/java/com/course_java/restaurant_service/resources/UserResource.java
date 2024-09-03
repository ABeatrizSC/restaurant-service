package com.course_java.restaurant_service.resources;

import com.course_java.restaurant_service.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define a classe como um controlador REST
@RequestMapping(value = "/users") // Mapeia as requisições para o endpoint /users
public class UserResource {

    @GetMapping // Responde a requisições HTTP GET
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        return ResponseEntity.ok().body(u); // Retorna o objeto User com status HTTP 200 (OK)
    }
}
