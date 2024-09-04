package com.course_java.restaurant_service.repositories;

import com.course_java.restaurant_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}