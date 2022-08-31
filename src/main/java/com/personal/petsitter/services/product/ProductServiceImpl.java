package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.PageResultDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.repositories.product.ProductReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductReposiroty reposiroty;
    @Override
    public Product.ListResponse getList(PageRequestDTO dto) {
        Page<Product.ListInfo> results = reposiroty.getList(dto);

        return new Product.ListResponse(new PageResultDTO<>(results));
    }

    @Override
    public Product.DetailInfo getDetail(Long idx) {
        return entityToDTO(reposiroty.findProductEntityByIdx(idx));
    }
}
