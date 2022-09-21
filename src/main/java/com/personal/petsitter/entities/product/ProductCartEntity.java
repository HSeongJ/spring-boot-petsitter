package com.personal.petsitter.entities.product;

import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product_Cart")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"petsitter", "customer"})
public class ProductCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_idx")
    private CustomerEntity customer;
}
