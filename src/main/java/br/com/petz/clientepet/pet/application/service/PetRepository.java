package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.domain.Pet;

import java.util.List;
import java.util.UUID;


public interface PetRepository {
    Pet save(Pet pet);

    List<Pet> buscaPetsDoClienteComId(UUID idCliente);

    Pet findPetDoClienteById(UUID idPet);

    void deletaPet(Pet pet);

}
