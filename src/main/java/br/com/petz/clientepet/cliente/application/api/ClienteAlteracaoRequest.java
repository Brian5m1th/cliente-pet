package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String celular;
    @NotBlank
    private String telefone;
    private Sexo sexo;
    @NotNull
    @DateTimeFormat
    private LocalDateTime dataNascimento;
    @NotNull
    private Boolean aceitaTermos;

    public Cliente converte(UUID idCliente) {
        return null;
    }
}
