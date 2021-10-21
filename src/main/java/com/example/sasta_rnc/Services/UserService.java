package com.example.sasta_rnc.Services;

import com.example.sasta_rnc.Models.User;

public interface UserService {
    public void save(User user);

    User findByUsername(String email);
}
