package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;

public interface ProductService {

    Product.ListResponse getList(PageRequestDTO dto);
}
