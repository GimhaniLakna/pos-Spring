package lk.ijse.posspring.posspring.service.impl;

import lk.ijse.posapispring.customStatusCodes.SelectedCustomerAndItemAndOrderErrorStatus;
import lk.ijse.posapispring.dao.ItemDao;
import lk.ijse.posapispring.dto.ItemStatus;
import lk.ijse.posapispring.dto.impl.ItemDTO;
import lk.ijse.posapispring.entity.impl.ItemEntity;
import lk.ijse.posapispring.exception.DataPersistException;
import lk.ijse.posapispring.exception.ItemNotFoundException;
import lk.ijse.posapispring.service.ItemService;
import lk.ijse.posapispring.util.AppUtil;
import lk.ijse.posapispring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setItemCode(AppUtil.generateItemId());
        ItemEntity saveItem = itemDao.save(mapping.toItemEntity(itemDTO));
        if(saveItem == null){
            throw new DataPersistException("Item Not Saved");
        }
    }

    @Override
    public void deleteItem(String itemCode) {
        Optional<ItemEntity> existItem = itemDao.findById(itemCode);
        if(!existItem.isPresent()){
            throw new ItemNotFoundException("Item ID With" + itemCode + "Not Found");
        }else{
            itemDao.deleteById(itemCode);
        }
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem = itemDao.findById(itemCode);
        if(!tmpItem.isPresent()){
            throw new ItemNotFoundException("Item ID With" + itemCode + "Not Found");
        }else {
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQtyOnHand(itemDTO.getQtyOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> allItems = itemDao.findAll();
        return mapping.asItemDTOList(allItems);
    }

    @Override
    public ItemStatus getItem(String itemCode) {
        if(itemDao.existsById(itemCode)){
            ItemEntity selectedItem = itemDao.getReferenceById(itemCode);
            return mapping.toItemDto(selectedItem);
        }else {
            return new SelectedCustomerAndItemAndOrderErrorStatus(2,"Item Code With" + itemCode
                                                                                                + "Not Found");
        }
    }
}
