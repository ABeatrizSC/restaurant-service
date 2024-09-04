package com.course_java.restaurant_service.repositories;

import com.course_java.restaurant_service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
