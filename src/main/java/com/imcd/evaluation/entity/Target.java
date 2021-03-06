package com.imcd.evaluation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Target {

    @Id @GeneratedValue
    @Column(name = "target_no")
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    private String targetId;

    @OneToMany(mappedBy = "target")
    private List<Score> scores = new ArrayList<>();
}
