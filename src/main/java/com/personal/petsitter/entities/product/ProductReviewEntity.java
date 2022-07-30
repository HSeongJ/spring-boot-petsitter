package com.personal.petsitter.entities.product;

import com.personal.petsitter.entities.base.BasePicturesEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "Product_Review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "product")
@DynamicInsert
public class ProductReviewEntity extends BasePicturesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prorev_idx")
    private Long idx;

    @Column(name = "cus_idx", nullable = false)
    private Long reviewWriter;

    @Column(length = 1000)
    private String title;

    @Column(length = 5000)
    private String content;

    @Column(columnDefinition = "DECIMAL(2, 1) DEFAULT 0.0")
    private Double rated;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
}
