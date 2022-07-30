package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsitterRepository extends JpaRepository<PetsitterEntity, Long>, PetsitterRepositoryCustom {

    PetsitterEntity findPetsitterEntityByIdx(Long idx);
}
