package com.personal.petsitter.repositories.petsitter;

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
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.personal.petsitter.entities.customer.QCustomerEntity.customerEntity;
import static com.personal.petsitter.entities.petsitter.QPetsitterReviewEntity.petsitterReviewEntity;

@Repository
public class PetsitterReviewRepositoryCustomImpl extends QuerydslRepositorySupport implements PetsitterReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public PetsitterReviewRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(PetsitterReviewEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Comment.Petsitter> getReviewList(Long petsitter_idx, int page) {
        JPAQuery<Comment.Petsitter> query = jpaQueryFactory
                .select(Projections.constructor(Comment.Petsitter.class,
                        petsitterReviewEntity.idx,
                        customerEntity.nickname,
                        petsitterReviewEntity.title,
                        petsitterReviewEntity.content,
                        petsitterReviewEntity.rated,
                        petsitterReviewEntity.regDate,
                        petsitterReviewEntity.modDate
                ))
                .from(petsitterReviewEntity)
                .leftJoin(customerEntity).on(petsitterReviewEntity.reviewWriter.eq(customerEntity.idx))
                .where(petsitterReviewEntity.petsitter.idx.eq(petsitter_idx));

        long totalCount = query.fetchCount();

        List<Comment.Petsitter> results = getQuerydsl()
                .applyPagination(PageRequest.of(page - 1, 30, Sort.by("idx").descending()), query).fetch();

        return new PageImpl<>(results, PageRequest.of(page - 1, 30, Sort.by("idx").descending()), totalCount);
    }
}
