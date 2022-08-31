package com.personal.petsitter.services.product;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.product.ProductCartEntity;
import com.personal.petsitter.entities.product.ProductEntity;
import com.personal.petsitter.repositories.product.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService {

    private final ProductCartRepository repository;

    @Override
    public String addCart(Long cus_idx, Long product_idx) {
        try {
            CustomerEntity customer = CustomerEntity.builder().idx(cus_idx).build();
            ProductEntity product = ProductEntity.builder().idx(product_idx).build();

            ProductCartEntity entity = ProductCartEntity.builder()
                    .customer(customer)
                    .product(product)
                    .build();

            repository.save(entity);
        } catch (Exception e) {
            return "추가 실패";
        }
        return "추가 완료";
    }
}
