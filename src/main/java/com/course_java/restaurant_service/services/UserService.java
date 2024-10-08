package com.course_java.restaurant_service.services;

import com.course_java.restaurant_service.entities.User;
import com.course_java.restaurant_service.repositories.UserRepository;
import com.course_java.restaurant_service.resources.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //anotation para especificar componente spring e funcionar o Autowired
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id); //monitora o objeto do id - depois é efetuado a operação no BD (findById a operacao é feito direto)
        updateData(entity, obj); //atualizar os dados do entitiy baseado nos que chegaram no obj
        return userRepository.save(entity); //salva
    }

    //campos que poderão ser atualizados
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
