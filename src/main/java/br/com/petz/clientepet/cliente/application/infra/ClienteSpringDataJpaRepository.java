package br.com.petz.clientepet.cliente.application.infra;

import br.com.petz.clientepet.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJpaRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByIdCliente(UUID idCliente);
}