package com.baohc.identity.service;

import com.baohc.identity.dto.request.UserCreationRequest;
import com.baohc.identity.dto.request.UserUpdateRequest;
import com.baohc.identity.dto.response.UserResponse;
import com.baohc.identity.entity.User;
import com.baohc.identity.mapper.UserMapper;
import com.baohc.identity.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Tầng user service để dữ lý các Business
 * Sử dụng lombok để tráng boilerplate code
 * @RequiredArgsConstructor để inject dependency
 * */
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserServiceImpl implements UserService {
    // Dependency Injection Constructor
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public UserResponse create(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("Username existed!");

        User user = userMapper.toUser(request);

        var userSaved = userRepository.save(user);

        return userMapper.toUserResponse(userSaved);
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toUserResponse(user))
                .toList();
    }

    @Override
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(
                userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    @Override
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user, request);
        user = userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id))
            throw new RuntimeException("User id not existed!");
        userRepository.deleteById(id);
    }
}
