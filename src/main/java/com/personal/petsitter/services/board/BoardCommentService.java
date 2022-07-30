package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Comment;

public interface BoardCommentService {

    Comment.BoardResponse getCommentList(Long idx);

}
