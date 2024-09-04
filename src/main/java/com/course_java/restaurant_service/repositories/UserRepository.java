package com.course_java.restaurant_service.repositories;

import com.course_java.restaurant_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
                                    //tipo da entidade - tipo do ID
public interface UserRepository extends JpaRepository<User, Long> {
    //spring data jpa tem uma implementação padrão para esta interface, não é necessário implementa-la
}
