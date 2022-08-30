package com.personal.petsitter.repositories.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.product.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {

    @Autowired
    private ProductReposiroty productReposiroty;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            ProductEntity entity = ProductEntity.builder()
                    .title("TestTitle" + i)
                    .content("TestContent" + i)
                    .price((int)(Math.random() * i) * 100)
                    .stock(i)
                    .family(i % 2 == 0 ? "Family1" : "Family2")
                    .category(i % 3 == 1 ? "Category1" : i % 3 == 2 ? "Category2" : "Category3")
                    .avgRated(Math.random() * 5)
                    .build();

            productReposiroty.save(entity);
        });
    }

    @Test
    public void testGetProductList() {
        PageRequestDTO dto = new PageRequestDTO();

        dto.setPage(1);
        dto.setFamily("Family1");
        dto.setCategory("Category1");
        dto.setKeyword("e1");

        log.info(productReposiroty.getList(dto).toList());
    }
}
