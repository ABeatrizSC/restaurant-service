package com.course_java.restaurant_service.repositories;

import com.course_java.restaurant_service.entities.OrderItem;
import com.course_java.restaurant_service.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}