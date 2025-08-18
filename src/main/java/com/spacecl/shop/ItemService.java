package com.spacecl.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> allItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> selectItemById(Long id){
        return itemRepository.findById(id);
    }

    public void saveItem(String title, Integer price){
        if(price < 0 || price > 9999){
            throw new IllegalArgumentException("가격");
        }
        if(title == null || title.isEmpty() || title.length() > 10){
            throw new IllegalArgumentException("제목");
        }

        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);

    }

    public void editItem(Long id, String title, Integer price){
        if(price < 0 || price > 9999){
            throw new IllegalArgumentException("가격");
        }
        if(title == null || title.isEmpty() || title.length() > 10){
            throw new IllegalArgumentException("제목");
        }

        try{
            Optional<Item> selectedItem = selectItemById(id);
            if(selectedItem.isPresent()){
                System.out.println(selectedItem.get());
                Item item = selectedItem.get();
                //그냥 new Item()가져온다음에 item.setId(id)로 해도됨
                item.setTitle(title);
                item.setPrice(price);
                itemRepository.save(item);
            }else{
                throw new Exception("찾지 못함");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
