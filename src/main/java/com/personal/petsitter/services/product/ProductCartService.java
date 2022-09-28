package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductCartService {

    ResponseEntity<String> addCart(Long customerIdx, Long productIdx);

    List<Product.CartListInfo> getCartList(Long customerIdx);
}
