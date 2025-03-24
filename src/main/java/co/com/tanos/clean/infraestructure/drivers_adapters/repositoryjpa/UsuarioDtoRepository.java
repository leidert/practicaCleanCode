package co.com.tanos.clean.infraestructure.drivers_adapters.repositoryjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UsuarioDtoRepository extends JpaRepository<UsuarioDto, Long> {
}
