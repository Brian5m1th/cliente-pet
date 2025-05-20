package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.*;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
    private final PetRepository petRepository;
    private final ClienteService clienteService;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[start] PetApplicationService - salvaPet");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.save(new Pet(idCliente, petRequest));
        log.info("[finish] PetApplicationService - salvaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClientePorId(idCliente);
        List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[finish] PetApplicationService - buscaPetsDoClienteComId");
        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetClienteDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[start] PetApplicationService - buscaPetDoClienteComId");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.findPetDoClienteById(idPet);
        log.info("[finish] PetApplicationService - buscaPetDoClienteComId");
        return new PetClienteDetalhadoResponse(pet);
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[start] PetApplicationService - deletaPetDoClienteComId");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.findPetDoClienteById(idPet);
        petRepository.deletaPet(pet);
        log.info("[finish] PetApplicationService - deletaPetDoClienteComId");
    }

    @Override
    public void alteraPetDoClienteComId(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest) {
        log.info("[start] PetApplicationService - alteraPetDoClienteComId");
        clienteService.buscaClientePorId(idCliente);
        Pet pet = petRepository.findPetDoClienteById(idPet);
        pet.altera(petAlteracaoRequest);
        petRepository.save(pet);
        log.info("[finish] PetApplicationService - alteraPetDoClienteComId");
    }
}