package com.spacecl.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "index.html"; //기본 폴더가 static
    }

    @GetMapping("/about")
    @ResponseBody
    String detail(){
        return "소개글";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        return ZonedDateTime.now().toString();
    }
}
