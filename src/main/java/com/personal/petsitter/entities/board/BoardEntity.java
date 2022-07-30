package com.personal.petsitter.entities.board;

import com.personal.petsitter.entities.base.BaseDateEntity;
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
public class BoardEntity extends BaseDateEntity {

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
