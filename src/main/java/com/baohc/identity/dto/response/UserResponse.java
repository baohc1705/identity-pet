package com.baohc.identity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/*
 *  Class dto để hiển thị dữ liệu cho client
 *
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;

    String username;

    String firstName;

    String lastName;

    LocalDate dob;
}
