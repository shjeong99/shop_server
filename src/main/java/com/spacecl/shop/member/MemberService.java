package com.spacecl.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberById(Long id){
        return memberRepository.findById(id);
    }


    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public void saveMember(String username, String password, String displayName)
            throws Exception{
        var result =  memberRepository.findByUsername(username);
        if (result.isPresent()) {
            throw new Exception("동일한 ID 설정 불가");
        }
        if(username == null || password == null || displayName == null){
            throw new Exception("빈값 불가");
        }
        if(username.length() < 8 || password.length() < 8){
            throw new Exception("짧은 길이로 ID/PW 설정 불가");
        }

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setDisplayName(displayName);
        this.memberRepository.save(member);
    }

    public void updateMember(Long id, String username, String password, String displayName){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        member.setId(id);
        member.setUsername(username);
        member.setPassword(password);
        member.setDisplayName(displayName);
        this.memberRepository.save(member);
    }
}
