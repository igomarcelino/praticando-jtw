package com.igomarcelino.treinando_jwt.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_lembrete;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private String mensagem;

    @CreationTimestamp
    private Instant creationTimestamp;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId_lembrete() {
        return id_lembrete;
    }

    public void setId_lembrete(Integer id_lembrete) {
        this.id_lembrete = id_lembrete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
