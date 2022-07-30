package com.personal.petsitter.services.hospital;

import com.personal.petsitter.dto.Hospital;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultEntityToDTO;
import com.personal.petsitter.entities.hospital.HospitalEntity;
import com.personal.petsitter.repositories.hospital.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public Hospital.Info getHospitalInfo(Long idx) {
        return entityToInfoDTo(hospitalRepository.findHospitalEntityByIdx(idx));
    }

    @Override
    public Hospital.ListResponse getHospitalList(PageRequestDTO pageRequestDTO) {
        Page<HospitalEntity> results = hospitalRepository
                .getHospitalEntityList(pageRequestDTO.getPageable(Sort.by("idx").descending()));

        Function<HospitalEntity, Hospital.Info> fn = (en -> entityToInfoDTo(en));

        return new Hospital.ListResponse(new PageResultEntityToDTO<>(results, fn));
    }
}
