package com.igomarcelino.treinando_jwt.controller;

import com.igomarcelino.treinando_jwt.dto.login.LoginRequestDTO;
import com.igomarcelino.treinando_jwt.dto.login.LoginResponseDTO;
import com.igomarcelino.treinando_jwt.entities.Roles;
import com.igomarcelino.treinando_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Autowired
    JwtEncoder jwtEncoder;

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){

        var user = userService.findByUserLogin(loginRequestDTO.userLogin());

        var now = Instant.now();
        var expiresIn = 300l;

        var scope = user.getRolesSet().
                stream().
                map(Roles::getRole_name).
                collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder().
                issuer("back-praticandojwt").
                subject(user.getId_user().toString()).
                expiresAt(now.plusSeconds(expiresIn)).
                claim("scope", scope).
                issuedAt(now).build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponseDTO(jwtValue,expiresIn));
    }
}
