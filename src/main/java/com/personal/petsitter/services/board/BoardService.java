package com.personal.petsitter.services.board;

import com.personal.petsitter.dto.Board;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.services.base.BasePicturesToList;

public interface BoardService extends BasePicturesToList {


    Board.ListResponse getBoardList(PageRequestDTO pageRequestDTO);

}
