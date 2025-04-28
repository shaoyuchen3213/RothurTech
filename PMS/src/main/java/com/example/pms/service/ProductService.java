package com.example.pms.service;

import com.example.pms.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProcutById(Long id);
    ProductDto updateById(ProductDto updateProduct, Long productId);
    void delete(Long productId);
    void deleteAll();
}
