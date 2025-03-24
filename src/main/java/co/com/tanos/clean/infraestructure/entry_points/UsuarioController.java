package co.com.tanos.clean.infraestructure.entry_points;

import co.com.tanos.clean.domain.model.Usuario;
import co.com.tanos.clean.domain.usecase.UsuarioUsecase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private  final UsuarioUsecase usuarioUsecase;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        var usuario = usuarioUsecase.buscar();
            return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findbyid(@RequestParam("id") Long id){
        var usuario = usuarioUsecase.bucarPorId(id);
        if (usuario.equals(null)){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws Exception {
        var resultUsuario = usuarioUsecase.guardar(usuario);
        if (resultUsuario.equals(null)){
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        usuarioUsecase.eliminar(id);
        return new ResponseEntity<>("delete ok", HttpStatus.OK);
    }

}
