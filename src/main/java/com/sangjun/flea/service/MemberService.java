package com.sangjun.flea.service;

import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public void join(MemberDto memberDto){
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member saveMember = memberDto.toEntity();
        memberRepository.save(saveMember);
    }

    //회원 전체 조회
    public Iterable<Member> findAll(){
        return memberRepository.findAll();
    }

    //회원 id로 조회
    public Member findOne(String memberId){
        return memberRepository.findByMemberId(memberId);
    }

    //회원 수정

    //ID 중복 체크





}
