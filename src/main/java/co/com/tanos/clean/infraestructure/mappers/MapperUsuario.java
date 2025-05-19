package co.com.tanos.clean.infraestructure.mappers;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDto;

import java.util.ArrayList;
import java.util.List;


public class MapperUsuario {

    private MapperUsuario() {
    }

    public static Usuario toUsuario(UsuarioDto usuarioDto){
        return Usuario.builder().id(usuarioDto.getId()).name(usuarioDto.getName()).email(usuarioDto.getEmail())
                .build();
    }
    public static List<Usuario> toUsuario(List<UsuarioDto> usuarioDto){
        var result = new ArrayList<Usuario>();
        for (var usuario: usuarioDto) {
            result.add(Usuario.builder().id(usuario.getId()).name(usuario.getName()).email(usuario.getEmail()).build());
        }
        return result;
    }

    public static UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder().id(usuario.getId()).name(usuario.getName()).email(usuario.getEmail())
                .build();
    }
}
