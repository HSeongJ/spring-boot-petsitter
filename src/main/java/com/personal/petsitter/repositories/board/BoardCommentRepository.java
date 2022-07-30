package com.personal.petsitter.repositories.board;

import com.personal.petsitter.entities.board.BoardCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardCommentEntity, Long> {
}