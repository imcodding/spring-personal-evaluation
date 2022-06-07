package com.imcd.evaluation.entity;

import com.imcd.evaluation.code.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String name;
    private String position;
    private String dept;

    @Enumerated(EnumType.STRING)
    private Role role;
}

