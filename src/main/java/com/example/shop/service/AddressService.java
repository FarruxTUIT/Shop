package com.example.shop.service;
import com.example.shop.dto.AddressDto;
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
        convertEntityToDto(address, addressDto);
        return addressDto;
    }

    public AddressDto create(AddressDto dto) {
        Address address = new Address();
        address.setCreatedAt(LocalDateTime.now());
        addressRepository.save(address);
        dto.setId(address.getId());
        return dto;
    }

    public boolean update(Integer id, AddressDto dto) {
        Address update = getEntity(id);
        convertDtoToEntity(update,dto);
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


    public void convertDtoToEntity(Address update, AddressDto dto) {
        update.setRegion(dto.getRegion());
        update.setCity(dto.getCity());
        update.setDistrict(dto.getDistrict());
        update.setStreet(dto.getStreet());
        update.setHome(dto.getHome());
    }

    public void convertEntityToDto(Address address, AddressDto addressDto) {
        address.setRegion(addressDto.getRegion());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setHome(addressDto.getHome());
    }

    public Address getEntity(Integer id) {
        Optional<Address> optional = addressRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Address not found");
        }
        return optional.get();
    }
}
