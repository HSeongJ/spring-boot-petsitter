package com.personal.petsitter.entities.customer;

import com.personal.petsitter.entities.base.BaseRegDateEntity;
import com.personal.petsitter.entities.base.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Pet")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "customer")
public class PetEntity extends BaseRegDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_idx")
    private Long idx;

    @Column(length = 100)
    private String family;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10)
    private Gender gender;

    private Integer age;

    @Column(length = 500)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customer;
}
