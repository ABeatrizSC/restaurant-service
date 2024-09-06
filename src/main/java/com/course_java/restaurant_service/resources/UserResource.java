package com.course_java.restaurant_service.resources;

import com.course_java.restaurant_service.entities.User;
import com.course_java.restaurant_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // Define a classe como um controlador REST
@RequestMapping(value = "/users") // Mapeia as requisições para o endpoint /users
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping // Responde a requisições HTTP GET do RequestMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list); // Retorna o objeto User com status HTTP 200 (OK)
    }

    //endpoint para o metodo findById
    //PathVariable = anotation para passar o id recebido a query
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);
        //rota dinâmica
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
