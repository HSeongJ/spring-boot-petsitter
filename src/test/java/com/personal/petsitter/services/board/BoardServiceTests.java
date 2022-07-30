package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.board.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testGetBoardList() {
        PageRequestDTO dto = new PageRequestDTO();

        log.info(boardService.getBoardList(dto));
    }
}
