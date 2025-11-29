package com.baohc.identity.service;

import com.baohc.identity.dto.request.UserCreationRequest;
import com.baohc.identity.dto.request.UserUpdateRequest;
import com.baohc.identity.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreationRequest request);

    List<UserResponse> getUsers();

    UserResponse getUser(String id);

    UserResponse updateUser(String id, UserUpdateRequest request);

    void deleteUser(String id);
}
