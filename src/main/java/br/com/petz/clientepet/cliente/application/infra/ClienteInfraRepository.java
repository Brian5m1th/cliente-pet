package br.com.petz.clientepet.cliente.application.infra;

import br.com.petz.clientepet.cliente.application.service.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJpaRepository clienteSpringDataJpaRepository;

    @Override
    public void salva(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - salva");
         clienteSpringDataJpaRepository.save(cliente);
        log.info("[finish] ClienteInfraRepository - salva");
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        log.info("[start] ClienteInfraRepository - findAll");
        List<Cliente> clienteList = clienteSpringDataJpaRepository.findAll();
        log.info("[finish] ClienteInfraRepository - findAll");
        return clienteList;
    }
}