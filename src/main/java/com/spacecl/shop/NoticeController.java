package com.spacecl.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notice")
    String notice(Model model){
        List<Notice> result = noticeRepository.findAll();
        model.addAttribute("notices", result);

        Notice notice = new Notice();

        //test
//        System.out.println("-- test --");
//        var object = new Person();
//        System.out.println(object.getOld());
//        object.setPlusOld();
//        System.out.println(object.getOld());
//        object.setOld(-10);
//        System.out.println(object.getOld());


        return "notice.html";
    }

}
