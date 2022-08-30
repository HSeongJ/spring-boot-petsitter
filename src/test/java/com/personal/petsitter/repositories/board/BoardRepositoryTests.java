package com.personal.petsitter.repositories.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.board.BoardEntity;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            CustomerEntity customer = CustomerEntity.builder()
                    .idx(i % 10L + 1)
                    .build();

            BoardEntity board = BoardEntity.builder()
                    .title("testBoardTitle" + i)
                    .content("testBoardContent" + i)
                    .category(i % 2 == 0 ? "category1" : "category2")
                    .writer(customer)
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    public void testGetList() {
        PageRequestDTO dto = new PageRequestDTO();
        dto.setPage(1);
        dto.setKeyword("e2");
//        dto.setCategory("category1");
        Page<Board.ListInfo> results = boardRepository.getList(dto);

        for(Board.ListInfo list : results) {
            log.info(list);
        }
    }

    @Test
    public void testGetDetailInfo() {
        log.info(boardRepository.getDetail(1L));
    }
}
