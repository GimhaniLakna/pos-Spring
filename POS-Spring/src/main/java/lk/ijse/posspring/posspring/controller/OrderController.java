package lk.ijse.posspring.posspring.controller;

import lk.ijse.posapispring.dto.impl.OrderDetailsDTO;
import lk.ijse.posapispring.dto.impl.OrderRequestDTO;
import lk.ijse.posapispring.exception.DataPersistException;
import lk.ijse.posapispring.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        try {
            orderService.placeOrder(orderRequestDTO.getOrder(),orderRequestDTO.getOrderDetails());
            logger.info("Order successfully placed");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Returning 400 Bad Request",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Save order unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDTO> getAllOrderDetails(){
        return orderService.getAllDetails();
    }

}
