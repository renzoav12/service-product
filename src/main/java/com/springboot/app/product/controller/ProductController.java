package com.springboot.app.product.controller;

import com.springboot.app.commons.model.Product;
import com.springboot.app.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

  private static Logger log = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private Environment env;

  @Value("${server.port}")
  private Integer port;

  @GetMapping("/getAll")
  public List<Product> list() {
    return productService.findAll().stream().map(product -> {
      product.setPort(port);
      return product;
    }).collect(Collectors.toList());
  }

  @GetMapping("/product/{id}")
  public Product getProduct(@PathVariable Long id) {
    Product p = productService.findById(id);
    //p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
    /*try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
    return p;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    return productService.save(product);
  }


  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
    log.info("##### ID :" + id);
    Product p = productService.findById(id);
    log.info("#### PRODUCT :" + p);
    p.setName(product.getName());
    p.setPrice(product.getPrice());
    p.setCreateAt(product.getCreateAt());
    return productService.save(p);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteById(id);
  }
}
