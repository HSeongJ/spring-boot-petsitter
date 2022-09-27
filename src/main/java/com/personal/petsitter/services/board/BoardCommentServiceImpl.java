package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.repositories.board.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements BoardCommentService {

    private final BoardCommentRepository boardCommentRepository;

    @Override
    public Comment.BoardResponse getCommentList(Long idx) {
        List<Object[]> result = boardCommentRepository.getCommentByBoardIdx(idx);

        List<Comment.Board> dtoList = new ArrayList<>();

        result.stream().forEach(i -> {
            Comment.Board dto = Comment.Board.builder()
                    .idx(Long.valueOf(String.valueOf(i[0])))
                    .nickname(String.valueOf(i[1]))
                    .content(String.valueOf(i[2]))
                    .regDate(LocalDateTime.parse(String.valueOf(i[3])))
                    .modDate(LocalDateTime.parse(String.valueOf(i[4])))
                    .build();

            dtoList.add(dto);
        });

        return new Comment.BoardResponse(new ArrayList<>(dtoList));
    }

    public String insertComment(Long idx, Comment.BoardWrite dto) {
        try {
            boardCommentRepository.save(dtoToEntity(idx, dto));
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
