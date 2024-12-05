package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    String saveItem(ItemSaveRequestDTO saveRequestDTO);

    String updateItem(ItemSaveRequestDTO requestDTO);

    ItemResponseDTO getItemById(int itemID);

    List<ItemResponseDTO> getAllItems();

    String deleteItem(int itemID);

    List<ItemAllDetailsResponseDTo> getAllItemsByState(boolean state);
}
