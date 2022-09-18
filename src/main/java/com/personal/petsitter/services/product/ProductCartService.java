package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Product;

import java.util.List;

public interface ProductCartService {

    String addCart(Long cusIdx, Long productIdx);

    List<Product.CartListInfo> getCartList(Long cusIdx);
}
