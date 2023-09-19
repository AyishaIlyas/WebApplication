package com.example.webapplication.repository;

import com.example.webapplication.entity.Admin;
import com.example.webapplication.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
