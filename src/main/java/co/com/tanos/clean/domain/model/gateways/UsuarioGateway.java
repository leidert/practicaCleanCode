package co.com.tanos.clean.domain.model.gateways;

import co.com.tanos.clean.domain.model.Usuario;

public interface UsuarioGateway {

    public Usuario guardar(Usuario usuario);

    public void eliminar(Long id);

    public Usuario bucarPorId(Long id);
}
