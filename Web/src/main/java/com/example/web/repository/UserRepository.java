package com.example.web.repository;

import com.example.web.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {
    User findByid(Integer id);
}
