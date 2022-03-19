package com.sangjun.flea.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @DisplayName("회원가입 성공")
    public void 회원가입() throws Exception{
        //given
        Member member = Member.builder()
                .memberId("lsj16632")
                .email("dhrkfrl16632@bible.ac.kr")
                .phoneNumber("010-5199-2492")
                .nickname("DevJun")
                .address("경기도 하남시")
                .password("lsj2486512!")
                .build();
        //when
        memberRepository.save(member);
        //then
        assertEquals(member, memberRepository.findByMemberId("lsj16632"));
    }

    @Test
    @DisplayName("메일형식 안맞출 경우, 비밀번호 형식 안맞출 경우")
    public void 데이터_검증(){

        //given
        Member member = Member.builder()
                .memberId("lsj16632")
                .email("dhrkfrl16632@bible.ac.kr")
                .phoneNumber("010-5199-2492")
                .nickname("DevJun")
                .address("경기도 하남시")
                .password("lsj2486512!")
                .build();

        //when


        //then

    }


}