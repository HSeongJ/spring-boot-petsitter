package com.personal.petsitter.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@ToString
@Getter
public class PageResultEntityToDTO<EN, DTO> {

    private List<DTO> dtoList;

    private int totalPage;

    private int page;

    private int size;

    private boolean next;

    public PageResultEntityToDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream()
                .map(fn)
                .collect(Collectors.toList());

        totalPage = result.getTotalPages();
        next = result.hasNext();

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        page = pageable.getPageNumber() + 1;
        size = pageable.getPageSize();
    }
}
