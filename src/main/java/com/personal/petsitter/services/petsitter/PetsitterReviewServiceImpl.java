package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.repositories.petsitter.PetsitterReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetsitterReviewServiceImpl implements PetsitterReviewService {

    private final PetsitterReviewRepository repository;

    @Override
    public Comment.PetsitterResponse getPetsitterReview(Long petsitterIdx, int page) {
        Page<Comment.Petsitter> results = repository.getReviewList(petsitterIdx, page);

        return new Comment.PetsitterResponse(new PageResultDTO<>(results));
    }
}
