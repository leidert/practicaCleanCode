package co.com.tanos.clean.infraestructure.drivers_adapters;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDto;

import java.util.List;

public class UserMother {

    public static Usuario getUser(){
        return Usuario.builder().id(1L)
                .name("leider")
                .email("leider@gmail.com").build();
    }
    public static Usuario getRequestUser(){
        return Usuario.builder()
                .id(1L)
                .name("leider")
                .email("leider@gmail.com").build();
    }
    public static UsuarioDto getUserRequestDto(){
        return UsuarioDto.builder()
                .id(1L)
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
    public static List<UsuarioDto> getAllUsersDto()
    {
        return List.of(
                getUserRequestDto()
        );
    }
}
