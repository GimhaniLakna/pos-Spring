package lk.ijse.posspring.posspring.dto.impl;

import lk.ijse.posapispring.dto.OrderRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDTO implements OrderRequestStatus {
    private OrderDTO order;
    private List<OrderDetailsDTO> orderDetails;
}
