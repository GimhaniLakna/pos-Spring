package lk.ijse.posspring.posspring.service.impl;

import lk.ijse.posapispring.dao.CustomerDao;
import lk.ijse.posapispring.dao.ItemDao;
import lk.ijse.posapispring.dao.OrderDao;
import lk.ijse.posapispring.dao.OrderDetailsDao;
import lk.ijse.posapispring.dto.impl.OrderDTO;
import lk.ijse.posapispring.dto.impl.OrderDetailsDTO;
import lk.ijse.posapispring.entity.impl.ItemEntity;
import lk.ijse.posapispring.entity.impl.OrderDetailsEntity;
import lk.ijse.posapispring.entity.impl.OrderEntity;
import lk.ijse.posapispring.exception.DataPersistException;
import lk.ijse.posapispring.service.OrderService;
import lk.ijse.posapispring.util.AppUtil;
import lk.ijse.posapispring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS) {
        try {
            orderDTO.setOrderId(AppUtil.generateOrderId());
            OrderEntity saveOrder = orderDao.save(mapping.toOrderEntity(orderDTO));
            if(saveOrder == null){
                throw new DataPersistException("Order not saved");
            }

            for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS){
                orderDetailsDTO.setDetailsId(AppUtil.generateOrderDetailsId());
                OrderDetailsEntity orderDetailsEntity = mapping.toOrderDetailsEntity(orderDetailsDTO);
                orderDetailsEntity.setOrder(saveOrder);
                orderDetailsDao.save(orderDetailsEntity);

                Optional<ItemEntity> item = itemDao.findById(String.valueOf(orderDetailsDTO.getItem()));

                if(item.isPresent()){
                    ItemEntity itemEntity = item.get();
                    int updateQty = itemEntity.getQtyOnHand() - orderDetailsDTO.getOrderQty();

                    if(updateQty < 0){
                        throw new DataPersistException("Insufficient stock for item :" + orderDetailsDTO.getItem());
                    }

                    itemEntity.setQtyOnHand(updateQty);
                    itemDao.save(itemEntity);
                }
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<OrderDetailsDTO> getAllDetails() {
        List<OrderDetailsEntity> allOrders = orderDetailsDao.findAll();
        return mapping.asOrderDetailsDTOList(allOrders);
    }
}
