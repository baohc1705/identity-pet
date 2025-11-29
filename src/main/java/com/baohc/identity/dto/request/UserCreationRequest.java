package com.baohc.identity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/*
 *  Class dto để client tương tác
 *  Sử dụng các annotation validation để validate các field của dto theo business rule
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @NotBlank(message = "Username not blank")
    @NotNull(message = "Username not null")
    @Size(min = 3, max = 100, message = "Username must be at between 3 and 100 character!")
    String username;

    @NotBlank(message = "Password not blank")
    @NotNull(message = "Password not null")
    @Size(min = 6, message = "Password must be at least 6 character!")
    String password;

    @NotBlank(message = "First name not blank")
    @NotNull(message = "First name not null")
    String firstName;

    @NotBlank(message = "Last name not blank")
    @NotNull(message = "Last name not null")
    String lastName;

    @NotNull(message = "Date of birth not null")
    LocalDate dob;
}
