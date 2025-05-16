package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class PetClienteListResponse {
    private UUID idPet;
    private UUID idClienteTutor;
    private String nomePet;
    private Porte porte;
    private TipoPet tipo;
    private String microchip;
    private String raca;
    private SexoPet sexoPet;
    private String pelagemCor;
    private LocalDateTime dataNascimento;
    private String rga;
    private Integer peso;

    private LocalDateTime dataHoraCadastro;

    public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
        return petsDoCliente.stream()
                .map(PetClienteListResponse::new)
                .collect(Collectors.toList());
    }

    public PetClienteListResponse(Pet pet) {
        this.idPet = pet.getIdPet();
        this.nomePet = pet.getNomePet();
        this.tipo = pet.getTipo();
        this.raca = pet.getRaca();
        this.pelagemCor = pet.getPelagemCor();
        this.dataNascimento = pet.getDataNascimento();
    }
}

