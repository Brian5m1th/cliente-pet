package br.com.petz.clientepet.pet.application.infra;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.service.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
