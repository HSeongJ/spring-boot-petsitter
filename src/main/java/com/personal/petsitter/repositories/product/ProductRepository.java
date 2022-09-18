package com.personal.petsitter.repositories.product;

import com.personal.petsitter.entities.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> , ProductRepositoryCustom {

    ProductEntity findProductEntityByIdx(Long productIdx);
}
