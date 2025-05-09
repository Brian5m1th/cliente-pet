package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Value
public class ClienteRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String celular;
    @NotBlank
    private String telefone;
    private Sexo sexo;
    @NotNull
    @DateTimeFormat
    private LocalDateTime dataNascimento;
    @CPF
    private String cpf;
    @NotNull
    private boolean aceitaTermos;
}
