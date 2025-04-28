package com.example.pms.service.impl;

import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;
import com.example.pms.exception.ResourceNotFoundException;
import com.example.pms.mapper.ProductMapper;
import com.example.pms.repository.ProductRepository;
import com.example.pms.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product saveProduct = productRepository.save(product);

        return ProductMapper.mapToProductDto(saveProduct);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products= new ArrayList<>(productRepository.findAll());

        return products.stream().map((product) -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProcutById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Product not in the list")
        );

        return ProductMapper.mapToProductDto(product);
    }


    public ProductDto updateById(ProductDto updateProduct, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () ->new ResourceNotFoundException("Product not in the list")
        );
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        product.setProductName(updateProduct.getProductName());
        product.setCategory(updateProduct.getCategory());
        product.setDescrption(updateProduct.getDescrption());
        Product updateProductObj = productRepository.save(product);
        return ProductMapper.mapToProductDto(updateProductObj);
    }

    @Override
    public void delete(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () ->new ResourceNotFoundException("Product not in the list")
        );
        productRepository.deleteById(product.getId());

    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}

