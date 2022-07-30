package com.personal.petsitter.repositories.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.board.BoardEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.personal.petsitter.entities.board.QBoardCommentEntity.boardCommentEntity;
import static com.personal.petsitter.entities.board.QBoardEntity.boardEntity;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Repository
public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(BoardEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Board.ListInfo> getList(PageRequestDTO dto) {
        JPQLQuery<Board.ListInfo> query = jpaQueryFactory
                .select(Projections.constructor(Board.ListInfo.class,
                        boardEntity.idx,
                        boardEntity.title,
                        boardEntity.writer.nickname,
                        boardEntity.picture1,
                        boardCommentEntity.idx.count())
                )
                .from(boardEntity)
                .leftJoin(boardCommentEntity).on(boardEntity.idx.eq(boardCommentEntity.board.idx))
                .where(eqCategory(dto.getCategory()),
                        containKeyword(dto.getKeyword())
                )
                .groupBy(boardEntity);
//                .orderBy(boardEntity.idx.desc())
//                .offset((dto.getPage() - 1) * dto.getSize())
//                .limit(dto.getSize() * 2)
        long totalCount = query.fetchCount();

        List<Board.ListInfo> results = getQuerydsl()
                .applyPagination(dto.getPageable(Sort.by("idx").descending()),
                        query).fetch();

        return new PageImpl<>(results, dto.getPageable(Sort.by("idx").descending()), totalCount);
    }

    private BooleanExpression eqCategory(String category) {
        return isEmpty(category) ? null : boardEntity.category.eq(category);
    }

    private BooleanExpression containKeyword(String keyword) {
        return isEmpty(keyword) ? null : boardEntity.title.contains(keyword);
    }
}
