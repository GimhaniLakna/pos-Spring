package lk.ijse.posspring.posspring.service;

import lk.ijse.posapispring.dto.impl.OrderDTO;
import lk.ijse.posapispring.dto.impl.OrderDetailsDTO;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS);
    List<OrderDetailsDTO> getAllDetails();
}
