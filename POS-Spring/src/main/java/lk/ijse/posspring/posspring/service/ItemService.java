package lk.ijse.posspring.posspring.service;

import lk.ijse.posapispring.dto.ItemStatus;
import lk.ijse.posapispring.dto.impl.ItemDTO;

import java.util.List;


public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void deleteItem(String itemCode);
    void updateItem(String itemCode,ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemCode);
}
