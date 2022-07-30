package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.board.BoardCommentService;
import com.personal.petsitter.services.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardCommentService boardCommentService;

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

    @GetMapping("/comment/{board_idx}")
    public Comment.BoardResponse getCommentList(@PathVariable("board_idx")Long idx) {
        return boardCommentService.getCommentList(idx);
    }

    @PostMapping("/comment/insert")
    public String insertComment(Comment.BoardWrite dto) {
        return boardCommentService.insertComment(dto);
    }
}
