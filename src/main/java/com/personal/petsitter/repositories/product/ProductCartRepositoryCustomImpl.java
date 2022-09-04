package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.Product;
import com.personal.petsitter.entities.product.ProductCartEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

import static com.personal.petsitter.entities.product.QProductCartEntity.productCartEntity;

@RequiredArgsConstructor
public class ProductCartRepositoryCustomImpl implements ProductCartRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public List<Product.CartListInfo> getCartListInfo(Long cus_idx) {
        List<Product.CartListInfo> entity = jpaQueryFactory
                .select(Projections.constructor(Product.CartListInfo.class,
                        productCartEntity.idx,
                        productCartEntity.product.category,
                        productCartEntity.product.title,
                        productCartEntity.product.price,
                        productCartEntity.product.picture1))
                .from(productCartEntity)
                .where(productCartEntity.customer.idx.eq(cus_idx)).fetch();

        return entity;
    }
}
