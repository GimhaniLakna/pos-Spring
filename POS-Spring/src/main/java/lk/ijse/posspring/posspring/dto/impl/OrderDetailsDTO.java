package lk.ijse.posspring.posspring.dto.impl;

import lk.ijse.posapispring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements OrderDetailsStatus {
    private String detailsId;
    private OrderDTO order;
    private ItemDTO item;
    private int orderQty;
    private double unitPrice;
}
