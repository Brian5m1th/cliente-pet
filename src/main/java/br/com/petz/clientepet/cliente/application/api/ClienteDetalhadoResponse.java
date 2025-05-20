package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Getter
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;
    private String telefone;
    private Sexo sexo;
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraCadastro;


    public ClienteDetalhadoResponse(Cliente cliente) {
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.telefone = cliente.getTelefone();
        this.sexo = cliente.getSexo();
        this.cpf = cliente.getCpf();
        this.aceitaTermos = cliente.getAceitaTermos();
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static ClienteDetalhadoResponse converte(List<Cliente> clienteList) {
        return null;
    }
}
