package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Category;
import org.example.springjpadata81.model.Product;
import org.example.springjpadata81.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    //List<Product> findByNameContainingIgnoreCase(String name);

    //List<Product> findByCategory(Category category);
    //List<Product> findByValues(Value value);


    List<Product> findByValues_Name(String valuesName);
}
