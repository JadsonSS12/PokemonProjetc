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

    public User update(Long id, User user){
        return userRepository.findById(id)
                .map(userToUpdate -> { // 'map' só executa se o usuário for encontrado
                    userToUpdate.setName(user.getName());
                    userToUpdate.setEmail(user.getEmail());
                    userToUpdate.setPassword(user.getPassword());
                    return userRepository.save(userToUpdate);
                }).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
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
