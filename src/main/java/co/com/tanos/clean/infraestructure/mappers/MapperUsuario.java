package co.com.tanos.clean.infraestructure.mappers;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperUsuario {

    public Usuario toUsuario(UsuarioDto usuarioDto){
        return Usuario.builder().id(usuarioDto.getId()).name(usuarioDto.getName()).Email(usuarioDto.getEmail())
                .build();
    }
    public List<Usuario> toUsuario(List<UsuarioDto> usuarioDto){
        var result = new ArrayList<Usuario>();
        for (var usuario: usuarioDto) {
            result.add(Usuario.builder().id(usuario.getId()).name(usuario.getName()).Email(usuario.getEmail()).build());
        }
        return result;
    }

    public UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder().id(usuario.getId()).name(usuario.getName()).Email(usuario.getEmail())
                .build();
    }
}
