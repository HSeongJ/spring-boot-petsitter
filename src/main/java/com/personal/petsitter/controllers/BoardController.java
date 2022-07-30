package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public Board.ListResponse getList(PageRequestDTO dto) {
        return boardService.getBoardList(dto);
    }

    @GetMapping("/{board_idx}")
    public Board.DetailInfo getDetailInfo(@PathVariable("board_idx")Long idx) {
        return boardService.getDetailInfo(idx);
    }

    @PostMapping("/insert")
    public String insertBoard(Board.InsertInfo dto) {
        return boardService.insertBoard(dto);
    }
}
