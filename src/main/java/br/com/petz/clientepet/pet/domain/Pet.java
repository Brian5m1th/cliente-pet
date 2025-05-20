package br.com.petz.clientepet.pet.domain;

import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Getter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID", name = "idPet", updatable = false, unique = true, nullable = false)
    private UUID idPet;
    @NotNull
    @Column(columnDefinition = "UUID", name = "idClienteTutor",  nullable = false)
    private UUID idClienteTutor;
    @NotBlank
    private String nomePet;
    @Enumerated(EnumType.STRING)
    private Porte porte;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPet tipo;
    private String microchip;
    @NotBlank
    private String raca;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SexoPet sexoPet;
    private String pelagemCor;
    @NotNull
    @DateTimeFormat
    private LocalDateTime dataNascimento;
    @NotNull
    private String rga;
    private Integer peso;

    private LocalDateTime dataHoraCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Pet(UUID idCliente, @Valid PetRequest petRequest) {
        this.idClienteTutor = idCliente;
        this.nomePet = petRequest.getNomePet();
        this.porte = petRequest.getPorte();
        this.tipo = petRequest.getTipo();
        this.microchip = petRequest.getMicrochip();
        this.raca = petRequest.getRaca();
        this.sexoPet = petRequest.getSexoPet();
        this.pelagemCor = petRequest.getPelagemCor();
        this.dataNascimento = petRequest.getDataNascimento();
        this.rga = petRequest.getRga();
        this.peso = petRequest.getPeso();
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public void altera(PetAlteracaoRequest petRequest) {
        this.nomePet = petRequest.getNomePet();
        this.porte = petRequest.getPorte();
        this.tipo = petRequest.getTipo();
        this.microchip = petRequest.getMicrochip();
        this.raca = petRequest.getRaca();
        this.sexoPet = petRequest.getSexoPet();
        this.pelagemCor = petRequest.getPelagemCor();
        this.dataNascimento = petRequest.getDataNascimento();
        this.rga = petRequest.getRga();
        this.peso = petRequest.getPeso();
        this.dataHoraUltimaAlteracao = LocalDateTime.now();
    }

}

