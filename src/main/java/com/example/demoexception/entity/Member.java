package com.example.demoexception.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 10, unique = true)
    private String name;

    @Column(length = 20)
    private String loginId;

    @Column(length = 30)
    private String loginPassword;

    @Column
    private int birthYear;

    @CreatedDate
    private LocalDateTime createdDate;

    @JsonIgnore
    public Member updateMember(String name) {
        this.name = name;

        return this;
    }

    @JsonIgnore
    public Member updatePassword(String password) {
        this.loginPassword = password;

        return this;
    }
}
