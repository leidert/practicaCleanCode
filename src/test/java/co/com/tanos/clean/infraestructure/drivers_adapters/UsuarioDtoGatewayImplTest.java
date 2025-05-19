package co.com.tanos.clean.infraestructure.drivers_adapters;


import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDto;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDtoGatewayImpl;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDtoRepository;
import co.com.tanos.clean.infraestructure.mappers.MapperUsuario;

import static co.com.tanos.clean.infraestructure.mappers.MapperUsuario.toUsuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UsuarioDtoGatewayImplTest {

    @Mock
    UsuarioDtoRepository repository;

    @InjectMocks
    UsuarioDtoGatewayImpl usuarioDtoGateway;

    @Autowired
    MapperUsuario mapperUsuario;


    @Test
    void createUserTest(){
        var userDto = UserMother.getUserRequestDto();
        var user = toUsuario(userDto);
        given(repository.save(any(UsuarioDto.class))).willReturn(userDto);

        var result = usuarioDtoGateway.guardar(user);
        assertEquals(user.getId(), result.getId());
        //verify(repository, times(1)).save(any(UsuarioDto.class));
        then(repository).should().save(userDto);


    }

    @Test
    void findByIdTest() {
        var userDto = UserMother.getUserRequestDto();
        var id = userDto.getId();
        given(repository.findById(id)).willReturn(Optional.of(userDto));

        var resull = usuarioDtoGateway.buscarPorId(id);

        assertEquals(userDto.getId(), resull.getId());

        //verify(repository, times(1)).findById(id);
        then(repository).should().findById(id);

    }

    @Test
    void findAllTest(){
        var usersDto = UserMother.getAllUsersDto();
        given(repository.findAll()).willReturn(usersDto);

        var resull = usuarioDtoGateway.buscar();

        assertEquals(usersDto.get(0).getId(), resull.get(0).getId());
        //verify(repository, times(1)).findAll();
        then(repository).should().findAll();
    }

    @Test
    void deleteTest(){
        Long id = 1L;
        usuarioDtoGateway.eliminar(id);
        verify(repository, times(1)).deleteById(id);

    }

}
