package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Comment;

public interface PetsitterReviewService {

    Comment.PetsitterResponse getPetsitterReview(Long petsitterIdx, int page);
}
