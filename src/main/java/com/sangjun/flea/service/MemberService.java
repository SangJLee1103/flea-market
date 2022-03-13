package com.sangjun.flea.service;

import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(MemberDto memberDto){
        Member saveMember = memberDto.toEntity();
        memberRepository.save(saveMember);
    }

    public Iterable<Member> findAll(){
        return memberRepository.findAll();
    }

}
