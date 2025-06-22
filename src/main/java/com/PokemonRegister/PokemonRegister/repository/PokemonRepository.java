package com.PokemonRegister.PokemonRegister.repository;

import com.PokemonRegister.PokemonRegister.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByNameContainingIgnoreCase(String name);
}
