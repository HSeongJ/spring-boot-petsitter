package com.personal.petsitter.entities.board;

import com.personal.petsitter.entities.base.BasePicturesEntity;
import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class BoardEntity extends BasePicturesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long idx;

    @Column(length = 1000, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 100)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity writer;
}
