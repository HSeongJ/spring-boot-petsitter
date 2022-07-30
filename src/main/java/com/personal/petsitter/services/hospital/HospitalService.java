package com.personal.petsitter.services.hospital;

import com.personal.petsitter.dto.Hospital;
import com.personal.petsitter.dto.PageRequestDTO;
import com.personal.petsitter.entities.hospital.HospitalEntity;
import com.personal.petsitter.services.base.BasePicturesToList;

public interface HospitalService extends BasePicturesToList {

    Hospital.Info getHospitalInfo(Long idx);

    Hospital.ListResponse getHospitalList(PageRequestDTO pageRequestDTO);

    default Hospital.Info entityToInfoDTo(HospitalEntity hospitalEntity) {
        Hospital.Info dto = Hospital.Info.builder()
                .hospital_idx(hospitalEntity.getIdx())
                .name(hospitalEntity.getName())
                .content(hospitalEntity.getContent())
                .openTime(hospitalEntity.getOpenTime().toString())
                .closeTime(hospitalEntity.getCloseTime().toString())
                .address(hospitalEntity.getAddress())
                .phonenumber(hospitalEntity.getPhonenumber())
                .pictures(picturesToList(hospitalEntity.getPicture1(), hospitalEntity.getPicture2(),
                        hospitalEntity.getPicture3(), hospitalEntity.getPicture4(),
                        hospitalEntity.getPicture5()))
                .build();
        return dto;
    }
}
