package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.repositories.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board.ListResponse getBoardList(PageRequestDTO pageRequestDTO) {

        Page<Board.ListInfo> results = boardRepository.getList(pageRequestDTO);

        return new Board.ListResponse(new PageResultDTO<>(results));
    }
}
