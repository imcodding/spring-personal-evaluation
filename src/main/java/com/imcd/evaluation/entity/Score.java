package com.imcd.evaluation.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Score {

    @Id @GeneratedValue
    @Column(name = "score_no")
    private Long no;

    @OneToOne
    @JoinColumn(name = "target_no")
    private Target target;

    private int passionScore;
    private int faithScore;
    private int responsibilityScore;
    private int harmonyScore;
    private int processingScore;
    private int customerScore;
    private int leadershipScore;
    private int expertScore;

    private String opinion;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
}
