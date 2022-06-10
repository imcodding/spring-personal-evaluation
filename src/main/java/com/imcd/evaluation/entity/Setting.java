package com.imcd.evaluation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting {

    @Id @GeneratedValue
    @Column(name = "setting_no")
    private Long no;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}

