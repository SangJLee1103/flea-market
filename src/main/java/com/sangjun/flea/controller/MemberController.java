package com.sangjun.flea.controller;

import com.sangjun.flea.domain.entity.Member;
import com.sangjun.flea.dto.MemberDto;
import com.sangjun.flea.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    //생성자를 통한 의존성 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/join")
    public void join(@RequestBody @Valid MemberDto memberDto) {
        memberService.join(memberDto);
    }

    @GetMapping("/read-all")
    public Iterable<Member> readAll(){
        return memberService.findAll();
    }
}
