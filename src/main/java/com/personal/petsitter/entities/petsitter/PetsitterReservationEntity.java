package com.personal.petsitter.entities.petsitter;

import com.personal.petsitter.entities.base.BaseDateEntity;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Petsitter_Reservation")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"petsitter", "customer"})
@DynamicInsert
public class PetsitterReservationEntity extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petres_idx")
    private Long idx;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    private Integer price;

    @Column(name = "pay_state", columnDefinition = "VARCHAR(20) DEFAULT '미결제'")
    private String payState;

    @Column(name = "res_state", columnDefinition = "VARCHAR(20) DEFAULT '예약'")
    private String resState;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetsitterEntity petsitter;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customer;
}
