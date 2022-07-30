package com.personal.petsitter.repositories.board;

import com.personal.petsitter.entities.board.BoardCommentEntity;
import com.personal.petsitter.entities.board.BoardEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardCommentRepositoryTests {

    @Autowired
    private BoardCommentRepository boardCommentRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
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
    public void testGetCommentByBoardIdx() {
        List<Object[]> results = boardCommentRepository.getCommentByBoardIdx(1L);

        for(Object[] list : results) {
            log.info(list[0] + ", " + list[1] + ", " + list[2] + ", " + list[3] + ", " + list[4]);
        }
    }
}
