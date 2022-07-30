package com.personal.petsitter.repositories.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;

public interface BoardRepositoryCustom {

    Page<Board.ListInfo> getList(PageRequestDTO dto);

    Tuple getDetail(Long idx);
}
