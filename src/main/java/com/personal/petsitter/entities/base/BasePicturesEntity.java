package com.personal.petsitter.entities.base;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract public class BasePicturesEntity extends BaseDateEntity {

    @Column(length = 500)
    private String picture1;

    @Column(length = 500)
    private String picture2;

    @Column(length = 500)
    private String picture3;

    @Column(length = 500)
    private String picture4;

    @Column(length = 500)
    private String picture5;
}
