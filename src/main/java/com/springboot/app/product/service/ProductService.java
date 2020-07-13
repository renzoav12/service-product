package com.springboot.app.product.service;

import com.springboot.app.commons.model.Product;
import java.util.List;

public interface ProductService {

  List<Product> findAll();

  Product findById(Long id);

  Product save(Product product);

  void deleteById(Long id);

}
