package com.baohc.identity.mapper;

import com.baohc.identity.dto.request.UserCreationRequest;
import com.baohc.identity.dto.request.UserUpdateRequest;
import com.baohc.identity.dto.response.UserResponse;
import com.baohc.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/*
*  Sử dụng mapper của mapstruct để tự sinh các code map đối tượng này sang đối kia
*  tránh boilerplate code
*
* */
@Mapper(componentModel = "spring")
public interface UserMapper {
    /*
    * Chuyển đổi lớp DTO sang entity
    * */
    User toUser(UserCreationRequest request);

    /*
    * Map từ entity sang DTO, để chỉ hiện thị những thông tin cần thiết
    * thông tin nhạy cảm như password có thể ẩn đi
    * */
    UserResponse toUserResponse(User user);

    /*
    * Map từ dto sang entity
    * không cần update username và id nên ignore các field này đi
    * */
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
