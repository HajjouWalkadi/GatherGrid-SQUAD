package com.squad.squad.repository;

import com.squad.squad.domain.Category;
import com.squad.squad.domain.Event;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryRepository {
    private final EntityManager em;
    public CategoryRepository(EntityManager em){
        this.em = em;
    }
    public Category save(Category category){
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    public List<Category> getAllCategories() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public Category getCategoryById(Long id) {
        return em.find(Category.class, id);
    }
}
