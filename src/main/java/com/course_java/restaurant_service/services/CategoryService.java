package com.course_java.restaurant_service.services;

import java.util.List;
import java.util.Optional;

import com.course_java.restaurant_service.entities.Category;
import com.course_java.restaurant_service.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}