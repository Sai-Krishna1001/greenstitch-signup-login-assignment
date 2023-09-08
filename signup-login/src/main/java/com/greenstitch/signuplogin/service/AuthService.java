package com.greenstitch.signuplogin.service;

import com.greenstitch.signuplogin.dto.LoginDto;
import com.greenstitch.signuplogin.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
