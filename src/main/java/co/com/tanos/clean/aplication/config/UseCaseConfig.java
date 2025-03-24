package co.com.tanos.clean.aplication.config;

import co.com.tanos.clean.domain.model.gateways.UsuarioGateway;
import co.com.tanos.clean.domain.usecase.UsuarioUsecase;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDtoGatewayImpl;
import co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa.UsuarioDtoRepository;
import co.com.tanos.clean.infraestructure.mappers.MapperUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    UsuarioUsecase usuarioUsecase(UsuarioGateway gateway){
        return new UsuarioUsecase(gateway);
    }

}
