package com.baohc.identity.controller;

import com.baohc.identity.dto.request.UserCreationRequest;
import com.baohc.identity.dto.request.UserUpdateRequest;
import com.baohc.identity.dto.response.ApiResponse;
import com.baohc.identity.dto.response.UserResponse;
import com.baohc.identity.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    // DI
    UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> create(@RequestBody UserCreationRequest request) {
        var user = userService.create(request);
        return ApiResponse.<UserResponse>builder()
                .code(222)
                .result(user)
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .code(222)
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .code(222)
                .result(userService.getUser(userId))
                .build();
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .code(222)
                .result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Void> delete(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<Void>builder()
                .code(222)
                .message("User has been deleted")
                .build();
    }
}
