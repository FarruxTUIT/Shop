package com.example.shop.configuration;

import com.example.shop.entity.User;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByEmailAndDeletedAtIsNull(username);
        if (optional.isEmpty()){
            throw new BadRequest("User name invalid");
        }
        User user = optional.get();

        return new CustomUserDetail(user);
    }
}
