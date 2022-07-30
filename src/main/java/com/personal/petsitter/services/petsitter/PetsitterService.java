package com.personal.petsitter.services.petsitter;

import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.dto.Petsitter;
import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.services.base.BasePicturesToList;

public interface PetsitterService extends BasePicturesToList {

    Petsitter.DetailInfo getPetsitterInfo(Long idx);
    Petsitter.ListResponse getPetsitterList(PageRequestDTO pageRequestDTO);

    default Petsitter.ListInfo entityToListDTO(PetsitterEntity entity) {
        Petsitter.ListInfo dto = Petsitter.ListInfo.builder()
                .petsitter_idx(entity.getIdx())
                .name(entity.getName())
                .content(entity.getContent())
                .career(entity.getCareer())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .avgRated(entity.getAvgRated())
                .pictures(picturesToList(entity.getPicture1(), entity.getPicture2(), entity.getPicture3(),
                                         entity.getPicture4(), entity.getPicture5()))
                .build();

        return dto;
     }

    default Petsitter.DetailInfo entityToDetailDTO(PetsitterEntity entity) {
        Petsitter.DetailInfo dto = Petsitter.DetailInfo.builder()
                .petsitter_idx(entity.getIdx())
                .name(entity.getName())
                .content(entity.getContent())
                .career(entity.getCareer())
                .price(entity.getPrice())
                .family(entity.getFamily())
                .category(entity.getCategory())
                .avgRated(entity.getAvgRated())
                .pictures(picturesToList(entity.getPicture1(), entity.getPicture2(), entity.getPicture3(),
                        entity.getPicture4(), entity.getPicture5()))
                .build();

        return dto;
    }
}
