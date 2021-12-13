package com.fornow.manageblebill.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/fetch")
    public ResponseEntity fetch(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
