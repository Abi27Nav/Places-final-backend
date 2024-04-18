package com.example.springjwtcustom.controller;

import com.example.springjwtcustom.entity.Category;
import com.example.springjwtcustom.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path="/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return  new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);

    }

    @GetMapping(path ="/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.FOUND);
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.FOUND);
    }

    @PutMapping(path="/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id,@RequestBody Category category){
        return new ResponseEntity<>(categoryService.updateCategory(category,id),HttpStatus.OK);
    }
    @DeleteMapping(path="/category{id}")
    public void deleteCategory(@PathVariable("id")int id){
        categoryService.deleteCategoryById(id);
    }


}
