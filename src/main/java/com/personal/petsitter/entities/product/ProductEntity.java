package com.personal.petsitter.entities.product;

import com.personal.petsitter.entities.base.BaseDateEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DynamicInsert
public class ProductEntity extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_idx")
    private Long idx;

    @Column(length = 1000, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private Integer price;

    @Column(length = 100)
    private String family;

    @Column(length = 100)
    private String category;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer stock;

    @Column(name = "avg_rated", columnDefinition = "DECIMAL(2, 1) DEFAULT 0.0")
    private Double avgRated;

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
