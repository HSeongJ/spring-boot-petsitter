package com.personal.petsitter.entities.product;

import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product_Order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"petsitter", "customer"})
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@DynamicInsert
public class ProductOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_idx")
    private Long idx;

    private Integer quantity;

    @Column(name = "total_price")
    private Integer totalPrice;

    @CreatedDate
    @Column(name = "pay_date", updatable = false)
    private LocalDateTime payDate;

    @Column(name = "delivery_state", columnDefinition = "VARCHAR(20) DEFAULT '배송준비'")
    private String deliveryState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_idx")
    private CustomerEntity customer;
}
