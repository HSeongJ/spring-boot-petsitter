package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.repositories.petsitter.PetsitterReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsitterReviewServiceImpl implements PetsitterReviewService{

    private final PetsitterReviewRepository repository;

    @Override
    public List<Comment.Petsitter> getPetsitterReview(Long petsitter_idx, int page) {

        Page<Comment.Petsitter> results = repository.getReviewList(petsitter_idx, page);

        return results.toList();
    }
}
