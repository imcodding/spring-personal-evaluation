package com.imcd.evaluation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptNo;

    private String name;

    @OneToMany(mappedBy = "dept")
    private List<User> users;

}
