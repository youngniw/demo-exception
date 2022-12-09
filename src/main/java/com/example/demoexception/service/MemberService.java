package com.example.demoexception.service;

import com.example.demoexception.dto.*;
import com.example.demoexception.entity.Member;
import com.example.demoexception.exception.exception.BadRequestException;
import com.example.demoexception.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 로그인
    public MemberDto login(LoginDto loginDto) {
        Member member = memberRepository.findByLoginIdAndLoginPassword(loginDto.getLoginId(), loginDto.getLoginPassword())
                .orElseThrow(() -> BadRequestException.FAIL_TO_LOGIN);

        return MemberDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .birthYear(member.getBirthYear())
                .build();
    }

    // 회원 정보 추가
    public Long saveMember(final RegisterDto registerDto) {
        // 이름이나 로그인 아이디가 이미 있을 시, 회원가입 안됨
        memberRepository.findByNameOrLoginId(registerDto.getName(), registerDto.getLoginId())
                .ifPresent(member -> {
                    if (member.getName().equals(registerDto.getName()))
                        throw BadRequestException.ALREADY_EXIST_MEMBER_NAME;
                    else
                        throw BadRequestException.ALREADY_EXIST_LOGIN_ID;
                });

        Member member = Member.builder()
                .name(registerDto.getName())
                .loginId(registerDto.getLoginId())
                .loginPassword(registerDto.getLoginPassword())
                .birthYear(registerDto.getBirthYear())
                .build();

        Member saveMember = memberRepository.save(member);

        return saveMember.getMemberId();
    }

    public MemberDto getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> BadRequestException.NOT_EXIST_MEMBER);

        return MemberDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .birthYear(member.getBirthYear())
                .build();
    }

    // 회원 정보 갱신
    public void updateMember(Long memberId, UpdateMemberDto memberDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> BadRequestException.NOT_EXIST_MEMBER);

        member.updateMember(memberDto.getName());
        memberRepository.save(member);
    }

    // 회원 비밀번호 갱신
    public void updateMemberPassword(Long memberId, PasswordDto passwordDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> BadRequestException.NOT_EXIST_MEMBER);

        if (!member.getLoginPassword().equals(passwordDto.getBeforePassword()))
            throw BadRequestException.NOT_VALID_PASSWORD;

        member.updatePassword(passwordDto.getAfterPassword());
        memberRepository.save(member);
    }
}
