package com.example.shop.service;

import com.example.shop.dto.ProductTypeDto;
import com.example.shop.entity.ProductType;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private OsService osService;

    @Autowired
    private BrandService brandService;

    public ProductTypeDto get(Integer id) {
        ProductType productType = getEntity(id);
        ProductTypeDto dto = new ProductTypeDto();
        dto.setMerchant(merchantService.get(dto.getMerchantId()));
        dto.setOs(osService.get(dto.getOsId()));
        dto.setBrand(brandService.get(dto.getBrandId()));
        convertDtoToEntity(dto, productType);
        return dto;
    }


    public ProductTypeDto create(ProductTypeDto dto) {
        ProductType productType = new ProductType();
        //TODO: check merchant
        merchantService.getEntity(dto.getMerchantId());
        productType.setMerchantId(dto.getMerchantId());
        //TODO: check os
        osService.getEntity(dto.getOsId());
        productType.setOsId(dto.getOsId());
        //TODO: check brand
        brandService.getEntity(dto.getBrandId());
        productType.setBrandId(dto.getBrandId());

        convertEntityToDto(productType, dto);

        productType.setCreatedAt(LocalDateTime.now());
        productTypeRepository.save(productType);
        dto.setId(productType.getId());
        return dto;
    }

    public boolean update(Integer id, ProductTypeDto dto) {
        ProductType productType = getEntity(id);
        //TODO: check merchant
        merchantService.getEntity(dto.getMerchantId());
        productType.setMerchantId(dto.getMerchantId());
        //TODO: check os
        osService.getEntity(dto.getOsId());
        productType.setOsId(dto.getOsId());
        //TODO: check brand
        brandService.getEntity(dto.getBrandId());
        productType.setBrandId(dto.getBrandId());

        productType.setUpdatedAt(LocalDateTime.now());
        productTypeRepository.save(productType);
        return true;
    }


    public boolean delete(Integer id) {
        ProductType productType = getEntity(id);
        productType.setDeletedAt(LocalDateTime.now());
        productTypeRepository.save(productType);
        return true;
    }

    public void convertDtoToEntity(ProductTypeDto dto, ProductType productType) {
        dto.setId(productType.getId());
        dto.setName(productType.getName());
        dto.setCore(productType.getCore());
        dto.setMaterial(productType.getMaterial());
        dto.setDisplay(productType.getDisplay());
        dto.setRam(productType.getRam());
        dto.setCameraFront(productType.getCameraFront());
        dto.setCameraBack(productType.getCameraBack());
        dto.setStorage(productType.getStorage());
    }

    public void convertEntityToDto(ProductType productType, ProductTypeDto dto) {
        productType.setName(dto.getName());
        productType.setCore(dto.getCore());
        productType.setMaterial(dto.getMaterial());
        productType.setDisplay(dto.getDisplay());
        productType.setRam(dto.getRam());
        productType.setCameraFront(dto.getCameraFront());
        productType.setCameraBack(dto.getCameraBack());

    }


    public ProductType getEntity(Integer id) {
        Optional<ProductType> optional = productTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Visit not found");
        }
        return optional.get();
    }
}
