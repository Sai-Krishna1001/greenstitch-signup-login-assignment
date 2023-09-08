package com.greenstitch.signuplogin.service.impl;

import com.greenstitch.signuplogin.dto.LoginDto;
import com.greenstitch.signuplogin.dto.RegisterDto;
import com.greenstitch.signuplogin.dto.RolesDto;
import com.greenstitch.signuplogin.entity.User;
import com.greenstitch.signuplogin.exception.TodoAPIException;
import com.greenstitch.signuplogin.repository.UserRepository;
import com.greenstitch.signuplogin.service.AuthService;
import com.greenstitch.signuplogin.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtService jwtService;

    private UserRepository userRepository;
//    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    @Override
    public String register(RegisterDto registerDto) {

        // check username is already exists or not
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRoles(RolesDto.USERE.toString());
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        roles.add(userRole);
//
//        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public String login(LoginDto loginDto) {

         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));
         if(authentication.isAuthenticated()) {
             return jwtService.generateToken(loginDto.getUsernameOrEmail());
         }
         else{
             return "user Credentials are wrong";
         }
    }
}
