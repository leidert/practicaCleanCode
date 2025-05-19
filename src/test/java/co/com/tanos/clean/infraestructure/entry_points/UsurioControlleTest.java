package co.com.tanos.clean.infraestructure.entry_points;

import co.com.tanos.clean.domain.exception.UserNotFoundException;
import co.com.tanos.clean.domain.usecase.UsuarioUsecase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UsuarioController.class)
class UsurioControlleTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioUsecase usuarioUsecase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUserTest() throws Exception {
        var reference = UserMother.getAllUsers();
        given(usuarioUsecase.buscar()).willReturn(reference);
        mockMvc.perform(
                get("/api/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(reference.get(0).getId()));

        then(usuarioUsecase).should(times(1)).buscar();
    }

    @Test
    void getUserByIdTest() throws Exception {
        var reference = UserMother.getUser();
        var id = reference.getId();
        given(usuarioUsecase.bucarPorId(id)).willReturn(reference);
        mockMvc.perform(
                get("/api/v1/usuario/%s".formatted(id))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(reference.getId()));

        then(usuarioUsecase).should(times(1)).bucarPorId(id);
    }

    @Test
    void getUserByIdThrowUserNotFoundException() throws Exception {
        var id = UserMother.getUser().getId();
        given(usuarioUsecase.bucarPorId(id)).willThrow(new UserNotFoundException(id));
        mockMvc.perform(
                get("/api/v1/usuario/%s".formatted(id))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        then(usuarioUsecase).should(times(1)).bucarPorId(id);
    }

    @Test
    void saveTest() throws Exception {
        var reference = UserMother.getUser();
        var usuario = UserMother.save();
        given(usuarioUsecase.guardar(usuario)).willReturn(reference);
        mockMvc.perform(
                post("/api/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        then(usuarioUsecase).should(times(1)).guardar(usuario);
    }
    @Test
    void saveThrowUserNotFoundException() throws Exception {
        var usuario = UserMother.save();
        given(usuarioUsecase.guardar(usuario)).willThrow(new UserNotFoundException());

        mockMvc.perform(
        post("/api/v1/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andDo(print())
                .andExpect(status().isNotFound());
        then(usuarioUsecase).should(times(1)).guardar(usuario);

    }
}
