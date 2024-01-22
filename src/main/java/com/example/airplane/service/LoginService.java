package com.example.airplane.service;

import com.example.airplane.dto.UserDto;
import com.example.airplane.entity.User;
import com.example.airplane.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String id, String password){
        return userRepository.findByIdAndPassword(id, password);
    }

    public boolean signup(UserDto userDto){
        try {
            User user = User.builder()
                    .id(userDto.getId())
                    .password(userDto.getPassword1())
                    .name(userDto.getName())
                    .address(userDto.getAddress())
                    .email(userDto.getEmail())
                    .build();

            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean idCheck(String id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            return true;
        }else {
            return false;
        }
    }
}
