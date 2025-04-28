package com.example.pms.controller;


import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;
import com.example.pms.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Build Add Product rest API
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto saveProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    //Build get Product rest API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")

    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        ProductDto getProduct = productService.getProcutById(id);
        return ResponseEntity.ok(getProduct);
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto updateProductInfo) {
        ProductDto productDto = productService.updateById(updateProductInfo, id);
        return ResponseEntity.ok(productDto);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Success delete");
    }

    //deleteAll
    @DeleteMapping
    public ResponseEntity<String> deleteAllProduct() {
        productService.deleteAll();
        return ResponseEntity.ok("Success delete");
    }
}


