package com.spacecl.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> id(Long id);
    Optional<Member> findByUsername(String username);
}
