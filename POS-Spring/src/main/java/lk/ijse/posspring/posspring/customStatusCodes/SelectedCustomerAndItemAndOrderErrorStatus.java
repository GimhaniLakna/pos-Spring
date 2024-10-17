package lk.ijse.posspring.posspring.customStatusCodes;

import lk.ijse.posapispring.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerAndItemAndOrderErrorStatus implements CustomerStatus, ItemStatus, OrderStatus,
                                                                    OrderDetailsStatus, OrderRequestStatus {
    private int statusCode;
    private String statusMassage;
}
