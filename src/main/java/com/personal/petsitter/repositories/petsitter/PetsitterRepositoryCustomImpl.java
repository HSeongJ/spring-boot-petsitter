package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.personal.petsitter.entities.petsitter.QPetsitterEntity.petsitterEntity;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Repository
public class PetsitterRepositoryCustomImpl extends QuerydslRepositorySupport implements PetsitterRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public PetsitterRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(PetsitterEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<PetsitterEntity> getList(PageRequestDTO dto) {
        JPQLQuery<PetsitterEntity> query = jpaQueryFactory
                .select(petsitterEntity)
                .from(petsitterEntity) // + ; return JPQLQuery<E>
                .where(eqCategory(dto.getCategory())); //return List

        long totalCount = query.fetch().size();

        List<PetsitterEntity> results = getQuerydsl()
                .applyPagination(dto.getPageable(Sort.by("idx").descending()),
                        query).fetch();

        return new PageImpl<>(results, dto.getPageable(Sort.by("idx").descending()), totalCount);
    }

    private BooleanExpression eqCategory(String category) {
        return isEmpty(category) ? null : petsitterEntity.category.eq(category);
    }
}
