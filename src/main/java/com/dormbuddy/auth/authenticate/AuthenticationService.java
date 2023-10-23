package com.dormbuddy.auth.authenticate;

import com.dormbuddy.auth.authenticate.Entities.AuthenticationRequest;
import com.dormbuddy.auth.authenticate.Entities.AuthenticationResponse;
import com.dormbuddy.auth.authenticate.Entities.RegisterRequest;
import com.dormbuddy.auth.jwt.JwtService;
import com.dormbuddy.auth.user.Role;
import com.dormbuddy.auth.user.User;
import com.dormbuddy.auth.user.UserRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    public AuthenticationResponse register(RegisterRequest request){
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        System.out.println(user);
        return AuthenticationResponse.builder().token(jwtService.generateToken(user)).build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .build();

    }

}
