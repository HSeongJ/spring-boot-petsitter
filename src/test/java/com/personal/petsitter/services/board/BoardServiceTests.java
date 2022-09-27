package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

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

    @Test
    public void testGetDetailInfo() {
        log.info(boardService.getDetailInfo(1L));
    }

    @Transactional
    @Commit
    @Test
    public void testInsertBoard() {
        Board.InsertInfo dto = Board.InsertInfo.builder()
                .title("insertTest2")
                .content("insertTest2")
                .category("category1")
                .picture1("insertTestPicture1")
                .picture2("insertTestPicture2")
                .picture3("insertTestPicture3")
                .picture4("insertTestPicture4")
                .picture5("insertTestPicture5")
                .build();

        log.info(boardService.insertBoard(10L, dto));

    }
}
