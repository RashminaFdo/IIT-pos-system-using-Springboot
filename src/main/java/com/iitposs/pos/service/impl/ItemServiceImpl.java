package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String saveItem(ItemSaveRequestDTO saveRequestDTO) {

        Item item = new Item(
                saveRequestDTO.getItemID(),
                saveRequestDTO.getName(),
                saveRequestDTO.getMeasuringType(),
                saveRequestDTO.getSupplierPrice(),
                saveRequestDTO.getDisplayPrice(),
                saveRequestDTO.getSellingPrice(),
                saveRequestDTO.getQtyOnHand(),
                saveRequestDTO.isActiveState()
        );
        itemRepo.save(item);
        return "saved";
    }

    @Override
    public String updateItem(ItemSaveRequestDTO requestDTO) {

        if (itemRepo.existsById(requestDTO.getItemID())) {
            Item item = itemRepo.getReferenceById(requestDTO.getItemID());

            item.setName(requestDTO.getName());
            item.setMeasuringType(requestDTO.getMeasuringType());
            item.setSupplierPrice(requestDTO.getSupplierPrice());
            item.setDisplayPrice(requestDTO.getDisplayPrice());
            item.setSellingPrice(requestDTO.getSellingPrice());
            item.setQtyOnHand(requestDTO.getQtyOnHand());
            item.setActiveState(requestDTO.isActiveState());

            itemRepo.save(item);

            return requestDTO.getName() + " has been updated...!";

        }else {
            return "something went wrong...!";
        }
    }

    @Override
    public ItemResponseDTO getItemById(int itemID) {

        if (itemRepo.existsById(itemID)) {
            Item item = itemRepo.getReferenceById(itemID);

            return new ItemResponseDTO(
                    item.getItemID(),
                    item.getName(),
                    item.getMeasuringType(),
                    item.getSupplierPrice(),
                    item.getDisplayPrice(),
                    item.getSellingPrice(),
                    item.getQtyOnHand(),
                    item.isActiveState()
            );
        }else {
            return null;
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {

        List<Item> items = itemRepo.findAll();
        List<ItemResponseDTO> responseDTOS = new ArrayList<>();

        for (Item item: items) {

            responseDTOS.add(new ItemResponseDTO(
                    item.getItemID(),
                    item.getName(),
                    item.getMeasuringType(),
                    item.getSupplierPrice(),
                    item.getDisplayPrice(),
                    item.getSellingPrice(),
                    item.getQtyOnHand(),
                    item.isActiveState()
            ));

        }
        return responseDTOS;
    }

    @Override
    public String deleteItem(int itemID) {
        if (itemRepo.existsById(itemID)) {
            itemRepo.deleteById(itemID);
            return itemID + " has been deleted...!";
        }else {
            return "Item not found...!";
        }
    }

    @Override
    public List<ItemAllDetailsResponseDTo> getAllItemsByState(boolean state) {
        List<Item> items = itemRepo.findAllByActiveState(state);
        List<ItemAllDetailsResponseDTo> responseDTos = new ArrayList<>();

        for (Item item: items) {

            responseDTos.add(new ItemAllDetailsResponseDTo(
                    item.getItemID(),
                    item.getName(),
                    item.getMeasuringType(),
                    item.getSupplierPrice(),
                    item.getDisplayPrice(),
                    item.getSellingPrice(),
                    item.getQtyOnHand(),
                    item.isActiveState()
            ));
        }
        return responseDTos;
    }
}
