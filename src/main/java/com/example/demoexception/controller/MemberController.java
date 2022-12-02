package com.example.demoexception.controller;

import com.example.demoexception.dto.MemberDto;
import com.example.demoexception.dto.PasswordDto;
import com.example.demoexception.dto.UpdateMemberDto;
import com.example.demoexception.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원 정보 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> getMemberInfo(@PathVariable("memberId") Long memberId) {
        MemberDto memberInfo = memberService.getMemberInfo(memberId);

        return ResponseEntity.ok(memberInfo);
    }

    // 회원 정보 갱신 (: 이름 변경)
    @PutMapping("/{memberId}")
    public ResponseEntity<Object> updateMemberInfo(@PathVariable("memberId") Long memberId,
                                                   @RequestBody @Valid UpdateMemberDto memberDto) {
        memberService.updateMember(memberId, memberDto);

        return ResponseEntity.ok(null);
    }

    // 회원 정보 갱신 (: 비밀번호 변경)
    @PutMapping("/{memberId}/password")
    public ResponseEntity<Object> changePassword(@PathVariable("memberId") Long memberId,
                                                 @RequestBody @Valid PasswordDto passwordDto) {
        memberService.updateMemberPassword(memberId, passwordDto);

        return ResponseEntity.ok(null);
    }
}
