package com.igomarcelino.treinando_jwt.service;

import com.igomarcelino.treinando_jwt.Repoositories.LembreteRepository;
import com.igomarcelino.treinando_jwt.Repoositories.UserRepository;
import com.igomarcelino.treinando_jwt.entities.Lembrete;
import com.igomarcelino.treinando_jwt.entities.User;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LembreteService {

    @Autowired
    LembreteRepository lembreteRepository;

    @Autowired
    UserRepository userRepository;

    public void save(String mensagem, Integer userid){
        Lembrete lembrete = new Lembrete();
        lembrete.setMensagem(mensagem);
        lembrete.setUser(userRepository.findById(userid).get());
        lembreteRepository.save(lembrete);

    }

    public Lembrete findById(Integer id){
        return lembreteRepository.findById(id).get();
    }

    public void deleteById(Integer id, JwtAuthenticationToken token){
        var lembrete = lembreteRepository.findById(id);
        var user = userRepository.findById(Integer.valueOf(token.getName()));

        if (lembrete.get().getUser().getId_user().equals(user.get().getId_user())){
            lembreteRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

}
