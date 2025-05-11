package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Category;
import org.example.springjpadata81.model.Product;
import org.example.springjpadata81.model.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    //List<Product> findByNameContainingIgnoreCase(String name);

    //List<Product> findByCategory(Category category);
    //List<Product> findByValues(Value value);


    List<Product> findByValues_Name(String valuesName);
    @Query("select  p from Product p where :categoryId is null or  p.category.id = :categoryId")
    Page<Product> findByCategory_Id(Long categoryId, Pageable pageable);
}
