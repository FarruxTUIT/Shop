package com.example.shop.service;

import com.example.shop.dto.product.BrandDto;
import com.example.shop.entity.Brand;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public BrandDto get(Integer id) {
        Brand brand = getEntity(id);
        BrandDto brandDto = new BrandDto();
        brandDto.setName(brand.getName());
        brandDto.setId(brand.getId());
        return brandDto;
    }

    public BrandDto create(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setCreatedAt(LocalDateTime.now());
        brandRepository.save(brand);
        brandDto.setId(brand.getId());
        return brandDto;
    }

    public boolean update(Integer id, BrandDto brandDto) {
        Brand update = getEntity(id);
        update.setName(brandDto.getName());
        update.setUpdatedAt(LocalDateTime.now());
        brandRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Brand delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        brandRepository.save(delete);
        return true;
    }
    public Brand getEntity(Integer id) {
        Optional<Brand> optional = brandRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Brand not found");
        }
        return optional.get();
    }
}
