package com.igomarcelino.treinando_jwt.dto;

public record LoginResponseDTO(String accessToken, Long expiresIn ) {
}
