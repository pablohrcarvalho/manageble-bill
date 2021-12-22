package com.fornow.manageblebill.product;

import com.fornow.manageblebill.categoria.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> fetchId(@PathVariable("id") String id) {
        Optional<Product> products = productRepository.findById(Long.parseLong(id));
        return ResponseEntity.ok(products);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        productRepository.deleteById(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){
        productRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
