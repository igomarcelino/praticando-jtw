package com.igomarcelino.treinando_jwt.dto.login;

public record LoginResponseDTO(String accessToken, Long expiresIn ) {
}
