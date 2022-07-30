package com.personal.petsitter.entities.product;

import com.personal.petsitter.entities.base.BasePicturesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
public class ProductEntity extends BasePicturesEntity {

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
}
