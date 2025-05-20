package br.com.petz.clientepet.pet.application.infra;

import br.com.petz.clientepet.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetSpringDataJpaRepository extends JpaRepository<Pet , UUID> {
    List<Pet> findByIdClienteTutor(UUID idClienteTutor);
}
