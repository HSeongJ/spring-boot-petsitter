package com.personal.petsitter.entities.petsitter;

import com.personal.petsitter.entities.base.BaseDateEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "Petsitter")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DynamicInsert
public class PetsitterEntity extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitter_idx")
    private Long idx;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String family;

    private Integer price = 0;

    @Column(length = 5000)
    private String content;

    @Column(length = 5000)
    private String career;

    @Column(name = "avg_rated", columnDefinition = "DECIMAL(2, 1) DEFAULT 0.0")
    private Double avgRated;

    @Column(length = 100)
    private String category;

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
