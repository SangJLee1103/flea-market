package com.sangjun.flea.repository;

import com.sangjun.flea.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // ID로 찾기
    Member findByMemberId(String memberId);
    //닉네임으로 찾기
    Member findByNickname(String nickName);
    Member findByPhoneNumber(String phoneNumber);
}