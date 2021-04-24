package com.daniloportillo.Necflis.controllers;

import com.daniloportillo.Necflis.entities.Category;
import com.daniloportillo.Necflis.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {


    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Category> getAllCategories(){
        Iterable<Category> categories = categoryRepository.findAll();
        return (Collection<Category>) categories;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category, @DateTimeFormat(pattern = "yyyy.MM.ddd") Date date){
        Category newCategory = categoryRepository.save(category);
        return newCategory;
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Category getCategory(@PathVariable(name = "id") Long id){
        Optional<Category> category = categoryRepository.findById(id);
        Category result = null;
        if(category.isPresent()){
            result = category.get();
        }
        return result;
    }



    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteCategory(@PathVariable(name = "id") Long id){

        categoryRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Category changeCategory(@PathVariable(name = "id") Long id , @RequestBody Category category){
        Optional<Category> data = categoryRepository.findById(id);
        if(data.isPresent()){
            Category actual = data.get();
            actual.setIdCategory(id);
            actual.setName(category.getName());
            actual.setDescription(category.getDescription());
            actual.setDateCreated(category.getDateCreated());
            Category changedCategory = categoryRepository.save(actual);
            return changedCategory;
        }
        return null;
    }

}
