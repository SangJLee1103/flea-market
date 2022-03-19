package com.sangjun.flea.dto;

import com.sangjun.flea.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String member_id;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "휴대폰 번호는 필수 입력 값입니다.")
    private String phone_number;

    @NotBlank(message = "닉네임 혹은 이름은 필수 입력 값입니다.")
    private String nickname;

    @NotBlank(message = "주소는 간단하게라도 입력해주세요.")
    private String address;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    //회원 생성(builder)
    @Builder
    public Member toEntity(){
        return Member.builder()
                .memberId(this.member_id)
                .email(this.email)
                .phoneNumber(this.phone_number)
                .nickname(this.nickname)
                .address(this.address)
                .password(this.password)
                .build();
    }
}
