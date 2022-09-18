package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.Product;
import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.product.ProductCartEntity;
import com.personal.petsitter.entities.product.ProductEntity;
import com.personal.petsitter.repositories.product.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService {

    private final ProductCartRepository repository;

    @Override
    public String addCart(Long cusIdx, Long productIdx) {
        try {
            CustomerEntity customer = CustomerEntity.builder().idx(cusIdx).build();
            ProductEntity product = ProductEntity.builder().idx(productIdx).build();

            ProductCartEntity entity = ProductCartEntity.builder()
                    .customer(customer)
                    .product(product)
                    .build();

            repository.save(entity);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @Override
    public List<Product.CartListInfo> getCartList(Long cusIdx) {
        return repository.getCartListInfo(cusIdx);
    }
}
