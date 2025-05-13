package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
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
        List<Cliente> clienteList = clienteRepository.buscaTodosClientes();
        log.info("[finish] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clienteList);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaClientePorId");
        List<Cliente> clienteList = clienteRepository.buscaTodosClientes();
        log.info("[finish] ClienteApplicationService - buscaClientePorId");
        return ClienteDetalhadoResponse.converte(clienteList);
    }

}