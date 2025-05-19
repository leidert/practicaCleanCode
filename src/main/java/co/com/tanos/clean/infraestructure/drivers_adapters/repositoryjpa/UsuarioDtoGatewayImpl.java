package co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.domain.model.gateways.UsuarioGateway;
import static co.com.tanos.clean.infraestructure.mappers.MapperUsuario.*;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class UsuarioDtoGatewayImpl implements UsuarioGateway {

    private final UsuarioDtoRepository repository;

    public UsuarioDtoGatewayImpl( UsuarioDtoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        var data = toDto(usuario);
        return toUsuario(repository.save(data));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        var usuario = repository.findById(id);
        return toUsuario(usuario.orElse(UsuarioDto.builder().build()));
    }

    @Override
    public List<Usuario> buscar() {
        var usuario = repository.findAll();
        return toUsuario(usuario);
    }
}
