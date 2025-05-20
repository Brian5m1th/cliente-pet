package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.*;
import br.com.petz.clientepet.pet.domain.Pet;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface PetService {
    PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);

    List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);

    PetClienteDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);

    void deletaPetDoClienteComId(UUID idCliente, UUID idPet );

    void alteraPetDoClienteComId(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest);
}
