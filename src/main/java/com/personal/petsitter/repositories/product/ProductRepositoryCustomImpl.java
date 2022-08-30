package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.entities.product.ProductEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.personal.petsitter.entities.product.QProductEntity.productEntity;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(ProductEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Product.ListInfo> getList(PageRequestDTO dto) {
        JPAQuery<Product.ListInfo> query = jpaQueryFactory
                .select(Projections.constructor(Product.ListInfo.class,
                        productEntity.idx,
                        productEntity.family,
                        productEntity.title,
                        productEntity.content,
                        productEntity.picture1,
                        productEntity.avgRated
                        ))
                .from(productEntity)
                .where(eqCategory(dto.getCategory()),
                        eqFamily(dto.getFamily()),
                        containKeyword(dto.getKeyword()));

        long totalCount = query.stream().count();

        List<Product.ListInfo> results = getQuerydsl()
                .applyPagination(dto.getPageable(Sort.by("avgRated").descending()), query).fetch();


        return new PageImpl<>(results, dto.getPageable(Sort.by("avgRated").descending()), totalCount);
    }

    private BooleanExpression eqCategory(String category) {
        return isEmpty(category) ? null : productEntity.category.eq(category);
    }

    private BooleanExpression eqFamily(String family) {
        return isEmpty(family) ? null : productEntity.family.eq(family);
    }

    private BooleanExpression containKeyword(String keyword) {
        return isEmpty(keyword) ? null : productEntity.title.contains(keyword);
    }
}
