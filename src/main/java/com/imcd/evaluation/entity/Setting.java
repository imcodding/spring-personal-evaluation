package com.imcd.evaluation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting {

    @Id @GeneratedValue
    @Column(name = "setting_no")
    private Long no;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

