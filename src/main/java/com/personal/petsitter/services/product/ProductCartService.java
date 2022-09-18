package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Product;

import java.util.List;

public interface ProductCartService {

    String addCart(Long customerIdx, Long productIdx);

    List<Product.CartListInfo> getCartList(Long customerIdx);
}
