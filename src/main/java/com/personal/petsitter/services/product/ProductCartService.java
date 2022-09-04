package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Product;

import java.util.List;

public interface ProductCartService {

    String addCart(Long cus_idx, Long product_idx);

    List<Product.CartListInfo> getCartList(Long cus_idx);
}
