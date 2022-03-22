package com.sangjun.flea.service;

import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.dto.ResponseData;
import com.sangjun.flea.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void join(MemberDto memberDto){
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member saveMember = memberDto.toEntity();
        memberRepository.save(saveMember);
    }

    //회원 전체 조회
    public Iterable<Member> findAll(){
        return memberRepository.findAll();
    }

    //회원 id로 회원 조회
    public Member findOne(String memberId){
        return memberRepository.findByMemberId(memberId);
    }

    public void checkMemberIdDuplication(MemberDto dto) {
        boolean usernameDuplicate = memberRepository.existsByMemberId(dto.toEntity().getMemberId());
        if (usernameDuplicate) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    public void checkNicknameDuplication(MemberDto dto) {
        boolean nicknameDuplicate = memberRepository.existsByNickname(dto.toEntity().getNickname());
        if (nicknameDuplicate) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    public void checkEmailDuplication(MemberDto dto) {
        boolean emailDuplicate = memberRepository.existsByEmail(dto.toEntity().getEmail());
        if (emailDuplicate) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

    public void checkPhoneNumberDuplication(MemberDto dto) {
        boolean phoneNumberDuplicate = memberRepository.existsByPhoneNumber(dto.toEntity().getPhoneNumber());
        if (phoneNumberDuplicate) {
            throw new IllegalStateException("이미 존재하는 휴대폰 번호입니다.");
        }
    }



    //회원 수정

    //ID 중복 체크





}
