package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.base.BasePicturesToList;
import com.querydsl.core.Tuple;

import java.time.LocalDateTime;
import java.util.Locale;

public interface BoardService extends BasePicturesToList {


    Board.ListResponse getBoardList(PageRequestDTO pageRequestDTO);

    Board.DetailInfo getDetailInfo(Long idx);

    default Board.DetailInfo tupleToDetailDTO(Tuple tuple) {
        Board.DetailInfo dto = Board.DetailInfo.builder()
                .idx(tuple.get(0, Long.class))
                .title(tuple.get(1, String.class))
                .writer(tuple.get(2, String.class))
                .content(tuple.get(3, String.class))
                .regDate(tuple.get(4, LocalDateTime.class))
                .modDate(tuple.get(5, LocalDateTime.class))
                .category(tuple.get(6, String.class))
                .pictures(picturesToList(tuple.get(7, String.class), tuple.get(8, String.class),
                        tuple.get(9, String.class), tuple.get(10, String.class), tuple.get(11, String.class)))
                .build();

        return dto;
    }
}
