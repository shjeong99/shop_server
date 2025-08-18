package com.spacecl.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
//@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){

        List<Item> result = itemService.allItems();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write(Model model){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@ModelAttribute Item item){

        String title = item.getTitle();
        Integer price = item.getPrice();

        itemService.saveItem(title,price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){

        try{
            Optional<Item> result = itemService.selectItemById(id);

            if(result.isPresent()){
                System.out.println(result.get());
                model.addAttribute("item", result.get());
            }else{
                return "redirect:/list";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/list";
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        return "detail";
    }

    @GetMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model){
        try {
            Optional<Item> result = itemService.selectItemById(id);

            if(result.isPresent()){
                System.out.println(result.get());
                model.addAttribute("item", result.get());
                return "modify";
            }else{
                return "redirect:/list";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/list";
        }

    }

//    @PutMapping("/edit/{id}")
    @PostMapping("/edit/{id}")
    String edit(@PathVariable Long id,
                @RequestParam String title,
                @RequestParam Integer price){

        System.out.println("PUT 요청으로 들어옴");
        itemService.editItem(id, title, price);
        return "redirect:/list";
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> errorHandler(){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청");
//    }
}
