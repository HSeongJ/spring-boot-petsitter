package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.entities.board.BoardEntity;
import com.personal.petsitter.repositories.board.BoardRepository;
import com.querydsl.core.Tuple;
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

    @Override
    public Board.DetailInfo getDetailInfo(Long idx) {
        Tuple result = boardRepository.getDetail(idx);

        return tupleToDetailDTO(result);
    }

    @Override
    public String insertBoard(Board.InsertInfo dto) {
        try {
            BoardEntity entity = dtoToEntity(dto);

            boardRepository.save(entity);
        } catch (Exception e) {
            return "입력 실패";
        }
        return "입력 성공";
    }
}