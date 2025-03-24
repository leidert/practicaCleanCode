package co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.domain.model.gateways.UsuarioGateway;
import co.com.tanos.clean.infraestructure.mappers.MapperUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@AllArgsConstructor
@Repository
public class UsuarioDtoGatewayImpl implements UsuarioGateway {

    private final MapperUsuario mapperUsuario;
    private final UsuarioDtoRepository repository;

    @Override
    public Usuario guardar(Usuario usuario) {

        var data = mapperUsuario.toDto(usuario);
        return mapperUsuario.toUsuario(repository.save(data));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        var usuario = repository.findById(id);
        return mapperUsuario.toUsuario(usuario.get());
    }

    @Override
    public List<Usuario> buscar() {
        var usuario = repository.findAll();
        return mapperUsuario.toUsuario(usuario);
    }
}
