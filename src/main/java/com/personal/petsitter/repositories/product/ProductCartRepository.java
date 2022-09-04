package com.personal.petsitter.repositories.product;

import com.personal.petsitter.entities.product.ProductCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCartEntity, Long>, ProductCartRepositoryCustom {
}
