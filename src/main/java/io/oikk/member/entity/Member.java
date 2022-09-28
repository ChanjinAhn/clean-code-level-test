package io.oikk.member.entity;

import io.oikk.common.repository.BaseTimeEntity;
import io.oikk.member.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public Member(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
