package com.example.webapplication.service;

import com.example.webapplication.entity.Admin;
import org.springframework.stereotype.Service;

public interface AdminService {
    Admin login(String username, String password);
}
