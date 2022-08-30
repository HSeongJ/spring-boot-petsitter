package com.personal.petsitter.controllers;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public Product.ListResponse getList(PageRequestDTO dto) {
        return productService.getList(dto);
    }
}
