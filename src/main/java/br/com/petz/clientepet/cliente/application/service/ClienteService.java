package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);

    void deletaClientePorId(UUID idCliente);

    void alteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);
}
