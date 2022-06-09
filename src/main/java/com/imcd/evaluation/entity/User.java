package com.imcd.evaluation.entity;

import com.imcd.evaluation.code.Role;
import com.imcd.evaluation.code.Status;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long no;

    private String userId;
    private String password;
    private String name;
    private String position;
    private String dept;

    @Enumerated(EnumType.STRING)
    private Status submitStatus;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Target> targets = new ArrayList<>();
}

