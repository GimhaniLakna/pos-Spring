package lk.ijse.posspring.posspring.dao;

import lk.ijse.posapispring.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
