package co.com.tanos.clean.infraestructure.entry_points;

import co.com.tanos.clean.domain.model.Usuario;

import java.util.List;

public class UserMother {

    public static Usuario getUser(){
        return Usuario.builder().id(1L)
                .name("leider")
                .email("leider@gmail.com").build();
    }
    public static Usuario save(){
        return Usuario.builder()
                .name("leider")
                .email("leider@gmail.com").build();
    }

    public static List<Usuario> getAllUsers()
    {
        return List.of(
                getUser()
        );
    }
}
