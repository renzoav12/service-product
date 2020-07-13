package com.springboot.app.product.service;

import com.springboot.app.commons.model.Product;
import com.springboot.app.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>)productRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Product findById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }

}
