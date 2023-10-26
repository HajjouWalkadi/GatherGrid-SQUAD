package com.squad.squad.service;

import com.squad.squad.domain.Category;
import com.squad.squad.repository.CategoryRepository;
import com.squad.squad.repository.EventRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category){
       validate(category);
        return  categoryRepository.save(category);

    }

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    public void validate(Category category){
        if(category.getName().isBlank()){
             throw new IllegalArgumentException("category is empty");
        }
        if(category.getName().length()>10){
            throw new IllegalArgumentException("category should be not less than 10 word");
        }
    }
}
