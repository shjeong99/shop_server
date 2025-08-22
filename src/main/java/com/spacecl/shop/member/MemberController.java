package com.spacecl.shop.member;

import com.spacecl.shop.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
//    private final MemberService memberService;

    @GetMapping("/register")
    String register(Model model){
        return "register";
    }

    @PostMapping("/addMember")
    String addMember(@ModelAttribute Member member) throws Exception {
        String username = member.getUsername();
        String password = member.getPassword(); //비번 암호화
        String displayName = member.getDisplayName();

        memberService.saveMember(username, password, displayName);
        return "redirect:/list";
    }

    @GetMapping("/login")
    String login(Model model){
        return "login";
    }

    @PostMapping("/loginMember")
    String loginMember(Model model){

        return "redirect:/list";
    }
}
