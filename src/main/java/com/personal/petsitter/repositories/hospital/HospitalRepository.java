package com.personal.petsitter.repositories.hospital;

import com.personal.petsitter.entities.hospital.HospitalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {

    HospitalEntity findHospitalEntityByIdx(Long idx);

    @Query(value = "SELECT h FROM HospitalEntity h",
            countQuery = "SELECT count(h) FROM HospitalEntity h")
    Page<HospitalEntity> getHospitalEntityList(Pageable pageable);
}
