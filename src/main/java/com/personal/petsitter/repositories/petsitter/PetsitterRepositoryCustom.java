package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import org.springframework.data.domain.Page;

public interface PetsitterRepositoryCustom {

    Page<PetsitterEntity> getList(PageRequestDTO dto);
}
