package com.personal.petsitter.repositories.petsitter;

import com.personal.petsitter.dto.Comment;
import org.springframework.data.domain.Page;

public interface PetsitterReviewRepositoryCustom {

    Page<Comment.Petsitter> getReviewList(Long petsitter_idx, int page);
}
