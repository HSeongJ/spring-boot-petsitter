package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Comment;

import java.util.List;

public interface PetsitterReviewService {

    List<Comment.Petsitter> getPetsitterReview(Long petsitter_idx, int page);
}
