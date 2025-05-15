package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;
import br.com.petz.clientepet.cliente.domain.Cliente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[start]   ClienteApplicationService - criaCliente");
        Cliente cliente = new Cliente(clienteRequest);
        clienteRepository.salva(cliente);
        log.info("[finish] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clienteList = clienteRepository.findByAll();
        log.info("[finish] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clienteList);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaClientePorId");
        Cliente cliente = clienteRepository.findById(idCliente);
        log.info("[finish] ClienteApplicationService - buscaClientePorId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - deletaClientePorId");
        clienteRepository.deleteById(idCliente);
        log.info("[finish] ClienteApplicationService - deletaClientePorId");
    }


    @Override
    public void alteraCliente(UUID idCliente,@Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteApplicationService - alteraCliente");
        Cliente cliente = clienteRepository.findById(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.salva(cliente);
        log.info("[finish] ClienteApplicationService - alteraCliente");
    }

}