package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Var;
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
        log.info("[idCliente] {}", idCliente);
        clienteService.buscaClientePorId(idCliente);
        Pet pet  = petRepository.save(new Pet(idCliente , petRequest));
        log.info("[finish] PetApplicationService - salvaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetApplicationService - buscaPetsDoClienteComId");
        log.info("[idCliente] {}", idCliente);
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
}