package com.squad.squad.service;

import com.squad.squad.domain.Category;
import com.squad.squad.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CategoryServiceTest {

    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    void createCategoryInvalidName() {
        //Test 2 Insertion valid name=""
        Category category = new Category("");
        Mockito.when(categoryRepository.save(category)).thenThrow(new IllegalArgumentException("invalid category"));
        assertThrows(IllegalArgumentException.class,()->categoryService.createCategory(category));
    }
    @Test
    void createCategoryValidName(){
        Category category1 = new Category("activity");
        Category category2 = new Category("activity");
        category2.setId(1L);
        Mockito.when(categoryRepository.save(category1)).thenReturn(category2);
        assertEquals(category2, categoryService.createCategory(category1));
    }
    @Test
    void createCategoryInvalidName2(){
        Category category = new Category("1234");
        Mockito.when(categoryRepository.save(category)).thenThrow(new IllegalArgumentException("invalid category"));
        assertThrows(IllegalArgumentException.class,()->categoryService.createCategory(category));
    }


}