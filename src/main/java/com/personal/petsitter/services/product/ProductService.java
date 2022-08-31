package com.personal.petsitter.services.product;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Product;
import com.personal.petsitter.entities.product.ProductEntity;
import com.personal.petsitter.services.base.BasePicturesToList;

public interface ProductService extends BasePicturesToList {

    Product.ListResponse getList(PageRequestDTO dto);

    Product.DetailInfo getDetail(Long idx);

    default Product.DetailInfo entityToDTO(ProductEntity entity) {
        Product.DetailInfo dto = Product.DetailInfo.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .category(entity.getCategory())
                .family(entity.getFamily())
                .avgRated(entity.getAvgRated())
                .price(entity.getPrice())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .pictures(picturesToList(entity.getPicture1(), entity.getPicture2(), entity.getPicture3(),
                        entity.getPicture4(), entity.getPicture5()))
                .build();
        return dto;
    }
}
