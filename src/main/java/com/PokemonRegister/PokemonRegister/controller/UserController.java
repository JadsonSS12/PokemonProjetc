package com.PokemonRegister.PokemonRegister.controller;


import com.PokemonRegister.PokemonRegister.entity.User;
import com.PokemonRegister.PokemonRegister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
        try{
            User userUpdate = userService.update(id, user);
            return ResponseEntity.ok(userUpdate);
        }catch(Exception e){
            System.out.println("Usuário não encontrado");
            return ResponseEntity.notFound().build();
        }
       // return userService.update(user);
    }

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
