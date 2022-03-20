package com.sangjun.flea.repository;

import com.sangjun.flea.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // ID로 찾기
    Member findByMemberId(String memberId);

    boolean existsByMemberId(String username);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);


}