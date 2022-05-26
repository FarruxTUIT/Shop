package com.example.shop.service;

import com.example.shop.dto.AddressDto;
import com.example.shop.dto.UserDto;
import com.example.shop.entity.Address;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressDto get(Integer id) {
        Address address = getEntity(id);
        AddressDto addressDto = new AddressDto();
        convertEntityToDto(address, addressDto);
        return addressDto;
    }

    public AddressDto create(UserDto dto) {
        Address address = new Address();
        address.setCreatedAt(LocalDateTime.now());
        return null;
    }

    public boolean update(Integer id, AddressDto dto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }

    private void convertEntityToDto(Address address, AddressDto addressDto) {
        address.setRegion(addressDto.getRegion());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setHome(addressDto.getHome());
    }

    private Address getEntity(Integer id) {
        Optional<Address> optional = addressRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Address not found");
        }
        return optional.get();
    }
}
