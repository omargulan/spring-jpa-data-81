package org.example.springjpadata81.controller;


import lombok.RequiredArgsConstructor;
import org.example.springjpadata81.model.Category;
import org.example.springjpadata81.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    @GetMapping("/{id}")
    public Category findById(@PathVariable long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public Category create (@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PutMapping("/{id}")
    public Category update (long id, @RequestBody Category category){
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        categoryRepository.deleteById(id);
    }

}
