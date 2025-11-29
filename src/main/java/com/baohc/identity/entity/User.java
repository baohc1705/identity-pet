package com.baohc.identity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/*
 * Sử dụng lombok để tránh việc boilerplate code
 * ==> Lặp lại getter, setter và các constructor
 * Dúng @Builder để tạo entity mới gọn code hơn
 * */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 255)
    String id;

    @Column(name = "username", length = 100, unique = true)
    String username;

    @Column(name = "password", length = 255)
    String password;

    @Column(name = "first_name", length = 50)
    String firstName;

    @Column(name = "last_name", length = 50)
    String lastName;

    @Column(name = "dob")
    LocalDate dob;
}
