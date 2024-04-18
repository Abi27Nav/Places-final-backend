package com.example.springjwtcustom.controller;

import com.example.springjwtcustom.entity.Category;
import com.example.springjwtcustom.entity.Places;
import com.example.springjwtcustom.service.CategoryService;
import com.example.springjwtcustom.service.PlacesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlacesController {
    private PlacesService placesService;
    private CategoryService categoryService;

    public PlacesController(PlacesService placesService, CategoryService categoryService) {
        this.placesService = placesService;
        this.categoryService = categoryService;
    }

    // <--- create new place
    @PostMapping()
    public ResponseEntity<Places> savePlaces(@RequestBody Places places){
        return new ResponseEntity<>(placesService.savePlaces(places), HttpStatus.CREATED);
    }
    // <--- get place by ID
    @GetMapping(path = "{id}")
    public ResponseEntity<Places> getPlacesById(@PathVariable("id") int id){
        return new ResponseEntity<>(placesService.getPlacesById(id),HttpStatus.FOUND);
    }

    // <--- get All places
    @GetMapping()
    public List<Places> getAllPlaces(){
        return placesService.getAllPlaces();
    }

    // <-- Update places
    @PutMapping(path="{id}")
    public ResponseEntity<Places> updatePlaces(@PathVariable("id") int id, @RequestBody Places places){
        return new ResponseEntity<>(placesService.updatePlaces(places,id),HttpStatus.OK);
    }


    // <-- Delete places by ID
    @DeleteMapping(path="{id}")
    public void deletePlaces(@PathVariable("id")int id){
        placesService.deletePlaces(id);
    }

    //<------------------ Category

    @PostMapping(path="/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return  new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);

    }

    @GetMapping(path ="/category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
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
