package com.personal.petsitter.entities.hospital;

import com.personal.petsitter.entities.base.BaseDateEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Hospital")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class HospitalEntity extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_idx")
    private Long idx;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 5000)
    private String content;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

    @Column(length = 1000, nullable = false)
    private String address;

    @Column(length = 30)
    private String phonenumber;

    @Column(length = 500)
    private String picture1;

    @Column(length = 500)
    private String picture2;

    @Column(length = 500)
    private String picture3;

    @Column(length = 500)
    private String picture4;

    @Column(length = 500)
    private String picture5;
}
