package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.services.product.ProductCartService;
import com.personal.petsitter.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final ProductCartService productCartService;

    @GetMapping("/list")
    public Product.ListResponse getList(PageRequestDTO dto) {
        return productService.getList(dto);
    }

    @GetMapping("/{product_idx}")
    public Product.DetailInfo getDetail(@PathVariable("product_idx")Long idx) {
        return productService.getDetail(idx);
    }

    @PostMapping("/addCart")
    public String addCart(Long cus_idx, Long product_idx) {
        return productCartService.addCart(cus_idx, product_idx);
    }

    @GetMapping("/cartlist")
    public List<Product.CartListInfo> getCartList(Long cus_idx) {
        return productCartService.getCartList(cus_idx);
    }
}
