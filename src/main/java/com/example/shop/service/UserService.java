package com.example.shop.service;
import com.example.shop.dto.user.UserDto;
import com.example.shop.entity.User;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AddressService addressService;

    public UserDto create(UserDto userDto) {
        User create = new User();
        Optional<User> optional = userRepository.findByEmailOrContactAndDeletedAtIsNull(userDto.getEmail(), userDto.getContact());
        if (optional.isPresent()){
            throw new BadRequest("User already taken");
        }
        //TODO: check userRole
        userRoleService.getEntity(userDto.getUserRoleId());
        //TODO: check image
        imageService.getEntity(userDto.getImageId());
        //TODO: check address
        addressService.getEntity(userDto.getAddressId());

        create.setCreatedAt(LocalDateTime.now());
        userRepository.save(create);
        return userDto;
    }

    public UserDto get(Integer id) {
        User user = getEntity(id);
        UserDto userDto = new UserDto();
        userDto.setUserRole(userRoleService.get(userDto.getUserRoleId()));
        userDto.setImage(imageService.get(userDto.getImageId()));
        userDto.setAddress(addressService.get(userDto.getImageId()));
        convertDtoToEntity(user,userDto);
        return userDto;
    }

    public User getEntity(Integer id) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }

    public boolean update(Integer id, UserDto userDto) {
        User update = getEntity(id);
        //TODO: check userRole
        userRoleService.getEntity(userDto.getUserRoleId());
        //TODO: check image
        imageService.getEntity(userDto.getImageId());
        //TODO: check address
        addressService.getEntity(userDto.getAddressId());

        update.setUpdatedAt(LocalDateTime.now());
        userRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        User delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        userRepository.save(delete);
        return true;
    }

    public void convertDtoToEntity(User user, UserDto userDto) {
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setContact(userDto.getContact());
    }
}
