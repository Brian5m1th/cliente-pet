package br.com.petz.clientepet.cliente.domain;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", name = "id", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String celular;
    @NotBlank
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull
    @DateTimeFormat
    private LocalDateTime dataNascimento;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;

    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.celular = clienteRequest.getCelular();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.getAceitaTermos();
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public void altera(@Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
        this.celular = clienteAlteracaoRequest.getCelular();
        this.telefone = clienteAlteracaoRequest.getTelefone();
        this.sexo = clienteAlteracaoRequest.getSexo();
        this.dataNascimento = clienteAlteracaoRequest.getDataNascimento();
        this.aceitaTermos = clienteAlteracaoRequest.getAceitaTermos();
    }
}