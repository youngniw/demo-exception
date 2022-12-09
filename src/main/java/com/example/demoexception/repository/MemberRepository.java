package com.example.demoexception.repository;

import com.example.demoexception.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByLoginIdAndLoginPassword(String loginId, String loginPassword);

    // 이미 존재하는 이름이거나 로그인 아이디일 경우에는 회원가입 안되게 함
    Optional<Member> findByNameOrLoginId(String name, String loginId);
}
