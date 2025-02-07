package com.igomarcelino.treinando_jwt.Repoositories;

import com.igomarcelino.treinando_jwt.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {
}
