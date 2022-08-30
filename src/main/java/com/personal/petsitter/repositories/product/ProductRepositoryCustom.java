package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;
import org.springframework.data.domain.Page;

public interface ProductRepositoryCustom {

    Page<Product.ListInfo> getList(PageRequestDTO dto);
}
