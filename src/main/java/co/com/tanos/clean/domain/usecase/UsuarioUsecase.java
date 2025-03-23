package co.com.tanos.clean.domain.usecase;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.domain.model.gateways.UsuarioGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioUsecase {

    private final UsuarioGateway usuarioGateway;

    public Usuario guardar(Usuario usuario) throws Exception {
        if (usuario.getId() == null){
            throw new Exception();
        }
        return usuarioGateway.guardar(usuario);
    }

    public void eliminar(Long id){
        try {
            usuarioGateway.eliminar(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Usuario bucarPorId(Long id){
        try {
            return usuarioGateway.bucarPorId(id);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new Usuario();
        }
    }
}
