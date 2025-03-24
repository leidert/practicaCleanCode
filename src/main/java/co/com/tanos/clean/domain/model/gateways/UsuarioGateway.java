package co.com.tanos.clean.domain.model.gateways;

import co.com.tanos.clean.domain.model.Usuario;

import java.util.List;

public interface UsuarioGateway {

    public Usuario guardar(Usuario usuario);

    public void eliminar(Long id);

    public Usuario buscarPorId(Long id);

    public List<Usuario> buscar();
}
