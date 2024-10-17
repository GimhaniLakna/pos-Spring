package lk.ijse.posspring.posspring.dto.impl;

import lk.ijse.posapispring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
}
