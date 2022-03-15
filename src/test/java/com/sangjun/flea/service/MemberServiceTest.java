package com.sangjun.flea.service;

import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void join(){

        //given
        Member member = Member.builder()
                        .id(1L)
                        .memberId("lsj16632")
                        .email("lsj16632@naver.com")
                        .phoneNumber("010-5199-2492")
                        .nickname("어려워")
                        .address("경기도 하남")
                        .password("lsj2486512!")
                        .build();
        MemberDto memberDto = new MemberDto();
        memberDto.toEntity();
        memberService.join(memberDto);

        //when

        //then
    }


}