package br.com.petz.clientepet.pet.application.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PetResponse {
    private UUID idPet;

}
