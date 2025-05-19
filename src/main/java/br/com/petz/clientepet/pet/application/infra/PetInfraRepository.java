package br.com.petz.clientepet.pet.application.infra;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.service.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
    private final PetSpringDataJpaRepository petSpringDataJpaRepository;

    @Override
    public Pet save(Pet pet) {
        log.info("[start] PetInfraRepository - save");
        Pet petSave = petSpringDataJpaRepository.save(pet);
        log.info("[finish] PetInfraRepository - save");
        return petSave;
    }

    @Override
    public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetInfraRepository - buscaPetsDoClienteComId");
        List<Pet> pets = petSpringDataJpaRepository.findByIdClienteTutor(idCliente);
        log.info("[finish] PetInfraRepository - buscaPetsDoClienteComId");
        return pets;
    }



    @Override
    public Pet findPetDoClienteById(UUID idPet) {
        log.info("[start] PetInfraRepository - findPetDoClienteById");
        var pet = petSpringDataJpaRepository.findById(idPet)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Pet não encontrado para o idPet: " + idPet));
        log.info("[finish] PetInfraRepository - findPetDoClienteById");
        return pet;
    }
}
