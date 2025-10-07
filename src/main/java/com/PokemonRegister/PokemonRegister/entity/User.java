package com.PokemonRegister.PokemonRegister.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     Long id;
    String name;
     String email;
     String password;

    public String validateEmail(String email){

        String reg = "^[^@]+@[^@]+\\+.[^@]+";

        if (email == null){
            return "o campo email está vazio";
        }
        if(!email.matches(reg)){
            return "O email não é válido";
        }
        return "";
    }

    public String validatePassword(String password){
        if(password == null){
            return " O campo senha não pode estar vazio";
        }
        if(password.length()<7){
            return "Senha deve ter mais que 5 caracteres";
        }
        return "";
    }
}
