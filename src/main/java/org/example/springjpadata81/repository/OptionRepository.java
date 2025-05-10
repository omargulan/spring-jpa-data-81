package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Product, Long> {


}
