package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save-item")
    public String saveItem(@RequestBody ItemSaveRequestDTO saveRequestDTO) {
        String message = itemService.saveItem(saveRequestDTO);
        return message;
    }
    @PutMapping(path = "/update-item")
    public String updateItem(@RequestBody ItemSaveRequestDTO requestDTO) {
        String message = itemService.updateItem(requestDTO);
        return message;
    }
    @GetMapping(
        path = "/get-item-by-id",
        params = "id"
    )
    public ItemResponseDTO getItemById(@RequestParam(value = "id") int itemID) {
        return itemService.getItemById(itemID);
    }
    @GetMapping(
        path = "/get-all-items"
    )
    public List<ItemResponseDTO> getAllItems() {
        return itemService.getAllItems();
    }
    @DeleteMapping(
        path = "/delete-item/{id}"
    )
    public String deleteItem(@PathVariable(value = "id") int itemID) {
        return itemService.deleteItem(itemID);
    }
    @GetMapping(
        path = "/get-all-items-by-state",
        params = "state"
    )
    public List<ItemAllDetailsResponseDTo> getItemsByState(@RequestParam(value = "state") boolean state) {
        List<ItemAllDetailsResponseDTo> dToList = itemService.getAllItemsByState(state);
        return dToList;
    }
}
