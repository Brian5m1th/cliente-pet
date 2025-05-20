package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
        log.info("[start] PetController - postPet");
        log.info("[idCliente] {}", idCliente);
        log.info("[petRequest] {}", petRequest);
        PetResponse pet = petService.criaPet(idCliente, petRequest);
        log.info("[finish] PetController - postPet");
        return pet;
    }

    @Override
    public List<PetClienteListResponse> getPetDoClienteComId(UUID idCliente) {
        log.info("[start] PetController - getPetDoClienteComId");
        log.info("[idCliente] {}", idCliente);
        List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComId(idCliente);
        log.info("[finish] PetController - getPetDoClienteComId");
        return petsDoCliente;
    }

    @Override
    public PetClienteDetalhadoResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[start] PetController - getPetDoClienteComId");
        log.info("[idPet] {} - [idPet] {}", idCliente, idPet);
        PetClienteDetalhadoResponse buscarPet = petService.buscaPetDoClienteComId(idCliente, idPet);
        log.info("[finish] PetController - getPetDoClienteComId");
        return buscarPet;
    }

    @Override
    public void deletePetDoClientePorId(UUID idCliente, UUID idPet) {
        log.info("[start] PetController - deletePetDoClientePorId");
        log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
        petService.deletaPetDoClienteComId(idCliente, idPet);
        log.info("[finish] PetController - deletePetDoClientePorId");
    }

    @Override
    public void patchAlteraPetDoCliente(UUID idCliente,@Valid PetAlteracaoRequest petAlteracaoRequest, UUID idPet) {
        log.info("[start] PetController - patchAlteraPetDoCliente");log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
        petService.alteraPetDoClienteComId(idCliente,idPet,petAlteracaoRequest);
        log.info("[finish] PetController - patchAlteraPetDoCliente");
    }
}
