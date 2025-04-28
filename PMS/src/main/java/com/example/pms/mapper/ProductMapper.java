package com.example.pms.mapper;

import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity(),
                product.getDescrption()
        );
    }
    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getPrice(),
                productDto.getCategory(),
                productDto.getQuantity(),
                productDto.getDescrption()
        );
    }
}
