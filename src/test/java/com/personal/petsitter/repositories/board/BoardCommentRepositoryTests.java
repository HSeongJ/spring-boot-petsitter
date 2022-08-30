package com.personal.petsitter.repositories.board;

import com.personal.petsitter.entities.board.BoardCommentEntity;
import com.personal.petsitter.entities.board.BoardEntity;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardCommentRepositoryTests {

    @Autowired
    private BoardCommentRepository boardCommentRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            BoardEntity board = BoardEntity.builder()
                    .idx((long)(Math.random() * 100) + 1).build();
            log.info(board.getIdx());

            BoardCommentEntity boardComment = BoardCommentEntity.builder()
                    .replyWriter(i % 40L + 1)
                    .content("BoardCommentTest" + i)
                    .board(board)
                    .build();
            boardCommentRepository.save(boardComment);
        });
    }

    @Test
    @Transactional
    public void showComment() {
        log.info(boardCommentRepository.getReferenceById(1003L));
    }

    @Test
    public void testGetReservation() {
        BoardEntity entity = BoardEntity.builder().idx(12L).build();

        log.info(boardCommentRepository.findBoardCommentEntitiesByBoardOrderByRegDateDesc(entity));
    }
}
