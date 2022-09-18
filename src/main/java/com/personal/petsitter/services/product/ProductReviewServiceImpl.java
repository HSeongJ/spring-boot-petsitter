package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.repositories.product.ProductReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewRepository repository;

    @Override
    public Comment.ProductResponse getReview(Long productIdx, int page) {
        Page<Comment.Product> results = repository.getReviewList(productIdx, page);

        return new Comment.ProductResponse(new PageResultDTO<>(results));
    }
}
