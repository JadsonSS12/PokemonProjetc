package com.PokemonRegister.PokemonRegister.controller;

import com.PokemonRegister.PokemonRegister.entity.Pokemon;
import com.PokemonRegister.PokemonRegister.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon){
        return pokemonService.create(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon update(@RequestBody Pokemon pokemon){
        return pokemonService.update(pokemon);
    }

    @GetMapping("/list")
    public List<Pokemon> list(){
        return pokemonService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        pokemonService.delete(id);
    }

    public List<Pokemon> sort(){
        return pokemonService.sort();
    }
}
