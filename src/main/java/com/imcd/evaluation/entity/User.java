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

    @Id @GeneratedValue
    private Long id;

    private String userId;
    private String name;
    private String position;

    @Enumerated(EnumType.STRING)
    private Role role;
}

