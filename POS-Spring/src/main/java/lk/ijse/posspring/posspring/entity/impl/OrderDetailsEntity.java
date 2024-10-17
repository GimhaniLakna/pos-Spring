package lk.ijse.posspring.posspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posapispring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity implements SuperEntity {
    @Id
    private String detailsId;

    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode")
    private ItemEntity item;
    private int orderQty;

    private double unitPrice;
}
