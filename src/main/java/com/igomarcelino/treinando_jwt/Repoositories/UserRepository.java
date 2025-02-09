package com.igomarcelino.treinando_jwt.Repoositories;

import com.igomarcelino.treinando_jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserLogin(String username);

}
