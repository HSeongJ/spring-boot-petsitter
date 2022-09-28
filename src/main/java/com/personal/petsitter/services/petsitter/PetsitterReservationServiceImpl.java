package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.entities.petsitter.PetsitterReservationEntity;
import com.personal.petsitter.repositories.petsitter.PetsitterReservationRepository;
import com.personal.petsitter.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetsitterReservationServiceImpl implements PetsitterReservationService {

    private final PetsitterReservationRepository repository;

    @Override
    public ResponseEntity<String> insertReservation(Long idx, Petsitter.ReservationRequest reservationInfo) {
        try {
            repository.save(dtoToReservationEntity(idx, reservationInfo));
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }

    @Transactional
    @Override
    public List<Petsitter.ReservationResponse> getReservation(Long customerIdx) {
        CustomerEntity customer = CustomerEntity.builder().idx(customerIdx).build();

        List<PetsitterReservationEntity> entities = repository.findPetsitterReservationEntitiesByCustomer(customer);

        List<Petsitter.ReservationResponse> dto = entities.stream()
                .map(entity -> reservationEntityToDTO(entity)).collect(Collectors.toList());

        return dto;
    }
}
