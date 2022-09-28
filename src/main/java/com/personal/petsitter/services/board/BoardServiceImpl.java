package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.entities.board.BoardEntity;
import com.personal.petsitter.repositories.board.BoardRepository;
import com.personal.petsitter.util.AppConstants;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> insertBoard(Long idx, Board.InsertInfo dto) {
        try {
            BoardEntity entity = dtoToEntity(idx, dto);

            boardRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<>(AppConstants.RESPONSE_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(AppConstants.RESPONSE_SUCCESS, HttpStatus.OK);
    }
}
