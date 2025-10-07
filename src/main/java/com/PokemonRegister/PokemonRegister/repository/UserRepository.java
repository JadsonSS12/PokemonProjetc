package com.PokemonRegister.PokemonRegister.repository;

import com.PokemonRegister.PokemonRegister.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
