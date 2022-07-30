package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.board.BoardEntity;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.services.base.BasePicturesToList;
import com.querydsl.core.Tuple;

import java.time.LocalDateTime;

public interface BoardService extends BasePicturesToList {


    Board.ListResponse getBoardList(PageRequestDTO pageRequestDTO);

    Board.DetailInfo getDetailInfo(Long idx);

    String insertBoard(Board.InsertInfo dto);

    default BoardEntity dtoToEntity(Board.InsertInfo dto) {
        CustomerEntity customer = CustomerEntity.builder().idx(dto.getIdx()).build();

        BoardEntity board = BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .category(dto.getCategory())
                .writer(customer)
                .picture1(dto.getPicture1()).picture2(dto.getPicture2()).picture3(dto.getPicture3())
                .picture4(dto.getPicture4()).picture5(dto.getPicture5())
                .build();

        return board;
    }



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
