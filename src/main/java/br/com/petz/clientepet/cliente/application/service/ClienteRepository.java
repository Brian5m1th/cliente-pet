package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository  {
    void salva(Cliente cliente);

    List<Cliente> buscaTodosClientes();
}
