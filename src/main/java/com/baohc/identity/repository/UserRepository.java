package com.baohc.identity.repository;

import com.baohc.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
*  User repository sử dụng để kết nối với db
*  Sử dụng JpaRepository để sinh ra các câu query CRUD
* */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
