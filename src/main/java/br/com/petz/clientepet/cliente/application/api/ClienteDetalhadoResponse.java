package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;

    public static ClienteDetalhadoResponse converte(List<Cliente> clienteList) {
        return null;
    }
}
