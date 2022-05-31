package com.example.shop.service;

import com.example.shop.dto.user.AddressDto;
import com.example.shop.entity.Address;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressDto get(Integer id) {
        Address address = getEntity(id);
        AddressDto addressDto = new AddressDto();
        convertDtoToEntity(address, addressDto);
        return addressDto;
    }

    public AddressDto create(AddressDto dto) {
        Address address = new Address();
        address.setCreatedAt(LocalDateTime.now());
        addressRepository.save(address);
        convertEntityToDto(address,dto);
        dto.setId(address.getId());
        return dto;
    }

    public boolean update(Integer id, AddressDto dto) {
        Address update = getEntity(id);
        convertEntityToDto(update, dto);
        update.setUpdatedAt(LocalDateTime.now());
        addressRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Address delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        addressRepository.save(delete);
        return true;
    }


    public void convertEntityToDto(Address update, AddressDto dto) {
        update.setRegion(dto.getRegion());
        update.setCity(dto.getCity());
        update.setDistrict(dto.getDistrict());
        update.setStreet(dto.getStreet());
        update.setHome(dto.getHome());
    }

    public void convertDtoToEntity(Address address, AddressDto addressDto) {
        addressDto.setId(address.getId());
        addressDto.setRegion(address.getRegion());
        addressDto.setCity(address.getCity());
        addressDto.setDistrict(address.getDistrict());
        addressDto.setStreet(address.getStreet());
        addressDto.setHome(address.getHome());
    }

    public Address getEntity(Integer id) {
        Optional<Address> optional = addressRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Address not found");
        }
        return optional.get();
    }
}
