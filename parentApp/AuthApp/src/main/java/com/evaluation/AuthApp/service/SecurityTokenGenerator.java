package com.evaluation.AuthApp.service;

import com.evaluation.AuthApp.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String,String>generateToken(User user);
}
