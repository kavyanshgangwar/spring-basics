package com.example.sasta_rnc.Repository;

import com.example.sasta_rnc.Models.User;

public interface UserRepository{
    public User findByEmail(String email);
    public void save(User user);
}