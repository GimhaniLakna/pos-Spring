package lk.ijse.posspring.posspring.service;

import lk.ijse.posapispring.dto.CustomerStatus;
import lk.ijse.posapispring.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerStatus getCustomer(String customerId);
}
