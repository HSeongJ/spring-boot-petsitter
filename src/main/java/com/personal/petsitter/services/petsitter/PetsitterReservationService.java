package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.entities.petsitter.PetsitterReservationEntity;

import java.util.List;

public interface PetsitterReservationService {

    String insertReservation(Petsitter.ReservationRequest reservationInfo);

    List<Petsitter.ReservationResponse> getReservation(Long cus_idx);

    default PetsitterReservationEntity dtoToReservationEntity(Petsitter.ReservationRequest dto) {
        CustomerEntity customer = CustomerEntity.builder().idx(dto.getCusIdx()).build();
        PetsitterEntity petsitter = PetsitterEntity.builder().idx(dto.getPetsitterIdx()).build();

        PetsitterReservationEntity entity = PetsitterReservationEntity.builder()
                .customer(customer)
                .petsitter(petsitter)
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .price(dto.getPrice())
                .build();

        return entity;
    }

    default Petsitter.ReservationResponse reservationEntityToDTO(PetsitterReservationEntity entity) {
        Petsitter.ReservationResponse dto = Petsitter.ReservationResponse.builder()
                .petresIdx(entity.getIdx())
                .petsitterName(entity.getPetsitter().getName())
                .cusIdx(entity.getCustomer().getIdx())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .price(entity.getPrice())
                .payState(entity.getPayState())
                .build();

        return dto;
    }
}
