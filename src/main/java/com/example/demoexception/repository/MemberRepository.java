package com.example.demoexception.repository;

import com.example.demoexception.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByLoginIdAndLoginPassword(String loginId, String loginPassword);
    Optional<Member> findByName(String name);
}
