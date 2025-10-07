package com.PokemonRegister.PokemonRegister.controller;


import com.PokemonRegister.PokemonRegister.entity.User;
import com.PokemonRegister.PokemonRegister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{id}")
    public User update(@RequestBody User user){
        try{
            userService.findById(user);
        }catch(Exception e){
            System.out.println("Usuário não encontrado");
        }
        return userService.update(user);
    }

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
