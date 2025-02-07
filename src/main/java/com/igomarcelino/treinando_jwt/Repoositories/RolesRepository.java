package com.igomarcelino.treinando_jwt.Repoositories;

import com.igomarcelino.treinando_jwt.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
