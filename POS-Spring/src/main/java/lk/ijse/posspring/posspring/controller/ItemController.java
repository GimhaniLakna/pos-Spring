package lk.ijse.posspring.posspring.controller;

import lk.ijse.posapispring.customStatusCodes.SelectedCustomerAndItemAndOrderErrorStatus;
import lk.ijse.posapispring.dto.ItemStatus;
import lk.ijse.posapispring.dto.impl.ItemDTO;
import lk.ijse.posapispring.exception.DataPersistException;
import lk.ijse.posapispring.exception.ItemNotFoundException;
import lk.ijse.posapispring.service.ItemService;
import lk.ijse.posapispring.util.RegEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO){
        try {
            itemService.saveItem(itemDTO);
            logger.info("Item save successful");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Returning 400 Bad Request",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Item save unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemCode") String itemCode){
        try {
            if(!RegEx.itemCodeMatcher(itemCode)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemCode);
            logger.info("Item delete successful");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            logger.warn("Returning 404 Not Found",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Item delete unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{itemCode}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemCode") String itemCode,
                                           @RequestBody ItemDTO itemDTO){

        try {
            if(!RegEx.itemCodeMatcher(itemCode) || itemDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemCode,itemDTO);
            logger.info("Item update successful");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            logger.warn("Returning 400 Bad Request",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Item update unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable ("itemCode") String itemCode){
        if(!RegEx.itemCodeMatcher(itemCode)){
            logger.error("Returning 400 Bad Request");
            return new SelectedCustomerAndItemAndOrderErrorStatus(1,"Item Code Is Not Valid");
        }
        return itemService.getItem(itemCode);
    }
}
