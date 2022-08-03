package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultEntityToDTO;
import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.repositories.petsitter.PetsitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PetsitterServiceImpl implements PetsitterService {

    private final PetsitterRepository petsitterRepository;

    @Override
    public Petsitter.ListResponse getPetsitterList(PageRequestDTO pageRequestDTO) {
        Page<PetsitterEntity> results =  petsitterRepository.getList(pageRequestDTO);

        Function<PetsitterEntity, Petsitter.ListInfo> fn = (entity -> entityToListDTO(entity));

        return new Petsitter.ListResponse(new PageResultEntityToDTO<>(results, fn));
    }

    @Override
    public Petsitter.DetailInfo getPetsitterInfo(Long idx) {
        return entityToDetailDTO(petsitterRepository.findPetsitterEntityByIdx(idx));
    }
}
