package com.personal.petsitter.repositories.board;

import com.personal.petsitter.entities.board.BoardCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardCommentRepository extends JpaRepository<BoardCommentEntity, Long> {

    @Query("SELECT bc.idx, c.nickname, bc.content, bc.regDate, bc.modDate " +
            "FROM BoardCommentEntity bc " +
            "LEFT JOIN bc.board " +
            "LEFT JOIN CustomerEntity c ON bc.replyWriter = c.idx " +
            "WHERE bc.board.idx = :idx")
    List<Object[]> getCommentByBoardIdx(@Param("idx") Long idx);

}