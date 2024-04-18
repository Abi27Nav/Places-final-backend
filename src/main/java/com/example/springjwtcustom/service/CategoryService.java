package com.example.springjwtcustom.service;

import com.example.springjwtcustom.Exceptions.ResourceNotFoundException;
import com.example.springjwtcustom.entity.Category;
import com.example.springjwtcustom.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id ){
        return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","Id",id));


    }

    public Category updateCategory(Category category,int id){
        Category c = categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","ID",id));
        c.setName(category.getName());
        c.setEnabled(category.getEnabled());
        categoryRepository.save(c);
        return c;

    }

    public void  deleteCategoryById(int id) {
        categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","ID",id));
        categoryRepository.deleteById(id);
    }



}
