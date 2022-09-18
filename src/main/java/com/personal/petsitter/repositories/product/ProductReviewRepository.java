package com.personal.petsitter.repositories.product;

import com.personal.petsitter.entities.product.ProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReviewEntity, Long>, ProductReviewRepositoryCustom {
}
