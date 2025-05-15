package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.domain.Cliente;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);

    List<Cliente> findByAll();

    Cliente findById(UUID idCliente);

    void deleteById(UUID idCliente);

    void altera(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);
}
