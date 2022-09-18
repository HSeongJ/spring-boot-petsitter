package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.Comment;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.services.product.ProductCartService;
import com.personal.petsitter.services.product.ProductReviewService;
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

    private final ProductReviewService productReviewService;

    @GetMapping("/list")
    public Product.ListResponse getList(PageRequestDTO dto) {
        return productService.getList(dto);
    }

    @GetMapping("/{productIdx}")
    public Product.DetailInfo getDetail(@PathVariable("productIdx")Long idx) {
        return productService.getDetail(idx);
    }

    @GetMapping("/review")
    public Comment.ProductResponse getReview(Long productIdx, int page) {
        return productReviewService.getReview(productIdx, page);
    }

    @PostMapping("/addCart")
    public String addCart(Long customerIdx, Long productIdx) {
        return productCartService.addCart(customerIdx, productIdx);
    }

    @GetMapping("/cartList")
    public List<Product.CartListInfo> getCartList(Long cusIdx) {
        return productCartService.getCartList(cusIdx);
    }
}
