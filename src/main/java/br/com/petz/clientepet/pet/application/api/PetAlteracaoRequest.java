package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class PetAlteracaoRequest {
    @NotBlank
    private String nomePet;
    @Enumerated(EnumType.STRING)
    private Porte porte;
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

}
