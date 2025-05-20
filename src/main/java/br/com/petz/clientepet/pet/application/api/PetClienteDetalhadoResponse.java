package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PetClienteDetalhadoResponse {
    private UUID idPet;
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

    public PetClienteDetalhadoResponse(Pet pet) {
        this.idPet = pet.getIdPet();
        this.nomePet = pet.getNomePet();
        this.porte = pet.getPorte();
        this.tipo = pet.getTipo();
        this.microchip = pet.getMicrochip();
        this.raca = pet.getRaca();
        this.sexoPet = pet.getSexoPet();
        this.pelagemCor = pet.getPelagemCor();
        this.dataNascimento = pet.getDataNascimento();
        this.rga = pet.getRga();
        this.peso = pet.getPeso();
    }

}