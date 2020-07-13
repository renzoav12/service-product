package com.springboot.app.product.repository;

import com.springboot.app.commons.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
