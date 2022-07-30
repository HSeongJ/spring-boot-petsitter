package com.personal.petsitter.entities.board;

import com.personal.petsitter.entities.base.BaseDateEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Board_Comment")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class BoardCommentEntity extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comm_idx")
    private Long idx;

    @Column(name = "cus_idx", nullable = false)
    private Long replyWriter;

    @Column(length = 5000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity board;
}
