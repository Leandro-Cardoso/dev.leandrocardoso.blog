package dev.leandrocardoso.blog.service;

import dev.leandrocardoso.blog.model.Category;
import dev.leandrocardoso.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;

    }

    public List<Category> getAllCategories() {

        return this.categoryRepository.findAll();

    }

}
