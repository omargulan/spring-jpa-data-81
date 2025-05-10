package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ValueRepository extends JpaRepository<Product, Long> {


}
