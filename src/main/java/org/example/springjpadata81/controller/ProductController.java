package org.example.springjpadata81.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpadata81.model.Product;
import org.example.springjpadata81.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public Product create (@RequestBody Product product){
        return productRepository.save(product);
    }
    @PutMapping("/{id}")
    public Product update (long id, @RequestBody Product product){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingProduct.setName(product.getName());
        return productRepository.save(existingProduct);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productRepository.deleteById(id);
    }

    @GetMapping("/search")
    List<Product> findByName(@RequestParam String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
