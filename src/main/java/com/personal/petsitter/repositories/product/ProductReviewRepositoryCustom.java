package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.Comment;
import org.springframework.data.domain.Page;

public interface ProductReviewRepositoryCustom {

    Page<Comment.Product> getReviewList(Long productIdx, int page);
}
