package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Comment;

public interface ProductReviewService {

    Comment.ProductResponse getReview(Long productIdx, int page);
}
