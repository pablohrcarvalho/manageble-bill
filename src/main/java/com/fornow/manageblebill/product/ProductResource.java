package com.fornow.manageblebill.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductRepository productRepository;

    Product product1;

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

    @PostMapping("/delete")
    public ResponseEntity delete(){
        productRepository.deleteById(product1.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        productRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
