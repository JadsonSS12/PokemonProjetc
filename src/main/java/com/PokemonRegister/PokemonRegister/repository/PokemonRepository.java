package com.PokemonRegister.PokemonRegister.repository;

import com.PokemonRegister.PokemonRegister.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
