package com.example.shop.service;

import com.example.shop.dto.product.ProductDto;
import com.example.shop.entity.Product;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeService productTypeService;

    public ProductDto get(Integer id) {
        Product product = getEntity(id);
        ProductDto dto = new ProductDto();
        dto.setProductType(productTypeService.get(dto.getProductTypeId()));
        convertDtoToEntity(dto, product);
        return dto;
    }


    public ProductDto create(ProductDto dto) {
        Product product = new Product();
        //TODO: check productType
        productTypeService.getEntity(dto.getProductTypeId());
        product.setProductTypeId(dto.getProductTypeId());

        convertEntityToDto(product, dto);
        product.setVisible(true);
        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
        dto.setId(product.getId());
        return dto;
    }

    public boolean update(Integer id, ProductDto dto) {
        Product product = getEntity(id);
        //TODO: check productType
        productTypeService.getEntity(dto.getProductTypeId());
        product.setProductTypeId(dto.getProductTypeId());

        convertEntityToDto(product, dto);
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
        return true;
    }


    public boolean delete(Integer id) {
        Product product = getEntity(id);
        product.setDeletedAt(LocalDateTime.now());
        product.setVisible(false);
        productRepository.save(product);
        return true;
    }

    public void convertDtoToEntity(ProductDto dto, Product product) {
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setRate(product.getRate());
    }

    public void convertEntityToDto(Product product, ProductDto dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setRate(dto.getRate());

    }


    public Product getEntity(Integer id) {
        Optional<Product> optional = productRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Product not found");
        }
        return optional.get();
    }
}
