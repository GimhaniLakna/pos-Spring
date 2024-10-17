package lk.ijse.posspring.posspring.dao;

import lk.ijse.posapispring.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
