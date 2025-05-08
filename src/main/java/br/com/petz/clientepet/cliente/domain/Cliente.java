package br.com.petz.clientepet.cliente.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false,unique = true, nullable = false )
    private UUID idCliente;
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

    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Cliente(LocalDateTime dataHoraCadastro, boolean aceitaTermos, String cpf, LocalDateTime dataNascimento, Sexo sexo, String telefone, String celular, String email, String nomeCompleto, UUID idCliente) {
        this.idCliente = idCliente;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.aceitaTermos = aceitaTermos;
        this.dataNascimento = dataNascimento;
        this.dataHoraCadastro = LocalDateTime.now();
    }
}