package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.Product;

import java.util.List;

public interface ProductCartRepositoryCustom {

    List<Product.CartListInfo> getCartListInfo(Long cusIdx);
}
