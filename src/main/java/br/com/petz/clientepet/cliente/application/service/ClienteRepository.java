package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);

    List<Cliente> findByAll();

    Cliente findById(UUID idCliente);

    void deleteById(UUID idCliente);
}
