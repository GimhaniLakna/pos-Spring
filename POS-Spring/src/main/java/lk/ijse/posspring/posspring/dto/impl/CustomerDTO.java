package lk.ijse.posspring.posspring.dto.impl;

import lk.ijse.posapispring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerTel;
}
