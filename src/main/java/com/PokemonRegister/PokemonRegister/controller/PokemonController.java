package com.PokemonRegister.PokemonRegister.controller;

import com.PokemonRegister.PokemonRegister.entity.Pokemon;
import com.PokemonRegister.PokemonRegister.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon){
        return pokemonService.create(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon update(@RequestBody Pokemon pokemon){
        return pokemonService.update(pokemon);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Pokemon> list(){
        return pokemonService.list();
    }

    /*@GetMapping
    public List<Pokemon> sort(){
        return pokemonService.sort();
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        pokemonService.delete(id);
    }


}
