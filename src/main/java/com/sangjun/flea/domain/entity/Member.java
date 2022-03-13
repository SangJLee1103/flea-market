package com.sangjun.flea.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "MEMBER")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", length = 20, unique = true, nullable = false)
    private String memberId;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 15, unique = true, nullable = false)
    private String phoneNumber;

    @Column(length = 30, unique = true, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 100, nullable = false)
    @JsonIgnore
    private String password;
}
