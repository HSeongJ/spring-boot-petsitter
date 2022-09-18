package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Comment;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardCommentServiceTests {

    @Autowired
    private BoardCommentService boardCommentService;

    @Test
    public void testGetCommentList() {
        log.info(boardCommentService.getCommentList(1L));
    }

    @Test
    public void testInsertComment() {
        Comment.BoardWrite dto = Comment.BoardWrite.builder()
                .boardIdx(1L)
                .customerIdx(1L)
                .content("LdfasfdjaslfjasjdfkTest")
                .build();

        boardCommentService.insertComment(dto);
    }
}
