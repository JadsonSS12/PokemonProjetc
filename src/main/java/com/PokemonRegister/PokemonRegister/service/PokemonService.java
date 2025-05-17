package com.PokemonRegister.PokemonRegister.service;

import com.PokemonRegister.PokemonRegister.entity.Pokemon;
import com.PokemonRegister.PokemonRegister.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    public Pokemon create(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Pokemon pokemon){
        try {
            pokemonRepository.findById(pokemon.getId());
        } catch(Exception e){
            System.out.println("Pokemon not found");
        }
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> list(){
        return pokemonRepository.findAll();
    }

    public void delete(Long id){
        pokemonRepository.deleteById(id);
        return;
    }

    public List<Pokemon> sort(){
        Sort sort = Sort.by("name").ascending();
        return pokemonRepository.findAll(sort);
    }
}
