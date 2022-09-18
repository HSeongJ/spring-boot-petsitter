package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.entities.board.BoardCommentEntity;
import com.personal.petsitter.entities.board.BoardEntity;

public interface BoardCommentService {

    Comment.BoardResponse getCommentList(Long idx);

    String insertComment(Comment.BoardWrite dto);

    default BoardCommentEntity dtoToEntity(Comment.BoardWrite dto) {
        BoardEntity board = BoardEntity.builder().idx(dto.getBoardIdx()).build();

        BoardCommentEntity entity = BoardCommentEntity.builder()
                .replyWriter(dto.getCustomerIdx())
                .content(dto.getContent())
                .board(board)
                .build();

        return entity;
    }
}
