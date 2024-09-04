package com.course_java.restaurant_service.repositories;

import com.course_java.restaurant_service.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
