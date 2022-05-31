package com.example.shop.service;

import com.example.shop.dto.product.MerchantDto;
import com.example.shop.entity.Merchant;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public MerchantDto get(Integer id) {
        Merchant merchant = getEntity(id);
        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setName(merchant.getName());
        merchantDto.setId(merchant.getId());
        merchantRepository.save(merchant);
        return merchantDto;
    }

    public MerchantDto create(MerchantDto merchantDto) {
        Merchant merchant = new Merchant();
        merchant.setName(merchantDto.getName());
        merchant.setCreatedAt(LocalDateTime.now());
        merchantRepository.save(merchant);
        merchantDto.setId(merchant.getId());
        return merchantDto;
    }

    public boolean update(Integer id, MerchantDto merchantDto) {
        Merchant update = getEntity(id);
        update.setName(merchantDto.getName());
        update.setUpdatedAt(LocalDateTime.now());
        merchantRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Merchant delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        merchantRepository.save(delete);
        return true;
    }
    public Merchant getEntity(Integer id) {
        Optional<Merchant> optional = merchantRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Merchant not found");
        }
        return optional.get();
    }
}
