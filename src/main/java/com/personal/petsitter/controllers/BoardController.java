package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.security.CurrentMember;
import com.personal.petsitter.security.CustomerPrincipal;
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

    @GetMapping("/{boardIdx}")
    public Board.DetailInfo getDetailInfo(@PathVariable("boardIdx")Long idx) {
        return boardService.getDetailInfo(idx);
    }

    @PostMapping("/insert")
    public String insertBoard(@CurrentMember CustomerPrincipal customer, Board.InsertInfo dto) {
        return boardService.insertBoard(customer.getIdx(), dto);
    }

    @GetMapping("/comment/{boardIdx}")
    public Comment.BoardResponse getCommentList(@PathVariable("boardIdx")Long idx) {
        return boardCommentService.getCommentList(idx);
    }

    @PostMapping("/comment/insert")
    public String insertComment(@CurrentMember CustomerPrincipal customer, Comment.BoardWrite dto) {
        return boardCommentService.insertComment(customer.getIdx(), dto);
    }
}
