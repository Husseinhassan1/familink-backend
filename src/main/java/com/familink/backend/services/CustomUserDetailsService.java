package com.familink.backend.services;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public UserDto createUser(UserDto userDto) {
//        UserEntity user = new UserEntity();
//        user.setEmail(userDto.getEmail());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        userRepository.save(user);
//
//        userDto.setId(user.getId());
//
//        return userDto;
//    }
//    public UserEntity getUserByEmailAndPassword(String email, String password) {
//        UserEntity user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password) {
//            return user;
//        }
//        return null;
//    }
//
//
//    public List<UserDto> getUserList() {
//        List<UserEntity> users = userRepository.findAll();
//        List<UserDto> result = new ArrayList<>();
//        for (UserEntity user : users) {
//            result.add(new UserDto(user.getId(),
//                    user.getEmail(),
//                    user.getFirstName(),
//                    user.getLastName(),
//                    user.getUsername(),
//
//        }
//        return result;
//    }
//
//    public UserDto getUser(long id) {
//        UserEntity user = userRepository.getById(id);
//        UserDto userDto = new UserDto(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getUsername());
//        return userDto;
//
//    }
//
//    public UserDto updateUser(long id, UserDto userDto) {
//        System.out.println("User found: " + id);
//        userDto.setId(id);
//        userDto.setEmail("");
//        userDto.setUsername("");
//        userDto.setFirstName("");
//        userDto.setLastName("");
//        userDto.setPassword("");
//        return userDto;
//    }
//
//    public void deleteUser(long id) {
//        System.out.println("Deleted " + id);
//    }
}
