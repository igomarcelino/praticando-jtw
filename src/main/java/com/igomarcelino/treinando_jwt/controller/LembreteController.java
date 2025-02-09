package com.igomarcelino.treinando_jwt.controller;

import com.igomarcelino.treinando_jwt.Repoositories.UserRepository;
import com.igomarcelino.treinando_jwt.dto.lembrete.LembreteRequestDTO;
import com.igomarcelino.treinando_jwt.service.LembreteService;
import com.igomarcelino.treinando_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class LembreteController {

    @Autowired
    LembreteService lembreteService;

    @Autowired
    UserService userService;


    @PostMapping("/lembrete")
    public ResponseEntity<Void> criarLembrete(@RequestBody LembreteRequestDTO lembreteRequestDTO, JwtAuthenticationToken token){

        lembreteService.save(lembreteRequestDTO.mensagem(),Integer.valueOf(token.getName()));
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/lembrete/{id}")
    public ResponseEntity<Void> deletarLemnbrete(@PathVariable("id") Integer id_lembrete, JwtAuthenticationToken token){

        lembreteService.deleteById(id_lembrete,token);

        return ResponseEntity.ok().build();
    }

}
