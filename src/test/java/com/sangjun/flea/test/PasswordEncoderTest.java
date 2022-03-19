package com.sangjun.flea.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화")
    void passwordEncoding(){
        //given
        String password = "lsj2486512!";

        //when
        String encodePassword = passwordEncoder.encode(password);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(password, encodePassword),
                () -> Assertions.assertTrue(passwordEncoder.matches(password, encodePassword))
        );
    }
}
