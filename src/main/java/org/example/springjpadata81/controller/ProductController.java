package org.example.springjpadata81.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpadata81.model.Product;
import org.example.springjpadata81.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//    public Page<Product> findAll(@RequestParam int page, @RequestParam int size){
//        Pageable pageable = PageRequest.of(page, size);
//        return productRepository.findAll(pageable);
//    }
    public List<Product> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "20") int size,
                                 @RequestParam(defaultValue = "id") String field,
                                 @RequestParam(defaultValue = "asc") String sortDirection,
                                 @RequestParam(required = false) Long categoryId
    ){
        System.out.println(categoryId);
        Sort sort  = Sort.by(Sort.Direction.fromString(sortDirection), field);

        Pageable pageable = PageRequest.of(page, size, sort);
        //return productRepository.findAll(pageable).getContent();
        return productRepository.findByCategory_Id(categoryId, pageable).getContent();
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

//    @GetMapping("/search")
//    List<Product> findByName(@RequestParam String name){
//        return productRepository.findByNameContainingIgnoreCase(name);
//    }
        @GetMapping("/search")
       public List<Product> findByName(@RequestParam String valueName){
            return productRepository.findByValues_Name(valueName);
        }
}
