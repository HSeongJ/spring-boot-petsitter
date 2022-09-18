package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.entities.petsitter.PetsitterReviewEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.personal.petsitter.entities.customer.QCustomerEntity.customerEntity;
import static com.personal.petsitter.entities.product.QProductReviewEntity.productReviewEntity;

public class ProductReviewRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductReviewRepositoryCustom {

    private JPAQueryFactory jpaQueryFactory;

    public ProductReviewRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(PetsitterReviewEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Comment.Product> getReviewList(Long productIdx, int page) {
        JPAQuery<Comment.Product> query = jpaQueryFactory
                .select(Projections.constructor(Comment.Product.class,
                        productReviewEntity.idx,
                        customerEntity.nickname,
                        productReviewEntity.title,
                        productReviewEntity.content,
                        productReviewEntity.rated,
                        productReviewEntity.regDate,
                        productReviewEntity.modDate,
                        productReviewEntity.picture1,
                        productReviewEntity.picture2,
                        productReviewEntity.picture3,
                        productReviewEntity.picture4,
                        productReviewEntity.picture5
                ))
                .from(productReviewEntity)
                .leftJoin(customerEntity).on(productReviewEntity.reviewWriter.eq(customerEntity.idx))
                .where(productReviewEntity.product.idx.eq(productIdx))
                .orderBy(productReviewEntity.regDate.desc());

        long totalCount = query.fetch().size();

        List<Comment.Product> results = query.fetch();

        return new PageImpl<>(results, PageRequest.of(page - 1, 30, Sort.by("regDate").descending()), totalCount);
    }
}
