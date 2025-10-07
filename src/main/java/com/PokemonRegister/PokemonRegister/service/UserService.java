package com.PokemonRegister.PokemonRegister.service;

import com.PokemonRegister.PokemonRegister.entity.User;
import com.PokemonRegister.PokemonRegister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        try{
            userRepository.findById(user.getId());
        }catch(Exception e){
            System.out.println("O usuário não existe");
        }
        return userRepository.save(user);
    }

    public void delete(Long id){

        userRepository.deleteById(id);

    }

    public void findById(User user){
        try {
             userRepository.findById(user.getId());
        }catch(Exception e){
            System.out.println("Usuário não encontrado");
        }
    }

    public List<User> list(){
        return userRepository.findAll();
    }
}
