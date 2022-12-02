package com.example.demoexception.controller;

import com.example.demoexception.dto.LoginDto;
import com.example.demoexception.dto.MemberDto;
import com.example.demoexception.dto.RegisterDto;
import com.example.demoexception.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final MemberService memberService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<MemberDto> login(@RequestBody @Valid LoginDto loginDto) {
        MemberDto memberDto = memberService.login(loginDto);

        return ResponseEntity.ok(memberDto);
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDto registerDto) {
        memberService.saveMember(registerDto);

        return ResponseEntity.ok(null);
    }
}
