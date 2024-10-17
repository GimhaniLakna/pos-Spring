package lk.ijse.posspring.posspring.util;

import lk.ijse.posapispring.dao.ItemDao;
import lk.ijse.posapispring.dto.impl.CustomerDTO;
import lk.ijse.posapispring.dto.impl.ItemDTO;
import lk.ijse.posapispring.dto.impl.OrderDTO;
import lk.ijse.posapispring.dto.impl.OrderDetailsDTO;
import lk.ijse.posapispring.entity.impl.CustomerEntity;
import lk.ijse.posapispring.entity.impl.ItemEntity;
import lk.ijse.posapispring.entity.impl.OrderDetailsEntity;
import lk.ijse.posapispring.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemDao itemDao;

    //For Customer Mapping
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }

    public CustomerDTO toCustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //For Item Mapping
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public ItemDTO toItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    //For order
    public OrderEntity toOrderEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    //For Order Details
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO,OrderDetailsEntity.class);
    }

    public List<OrderDetailsDTO> asOrderDetailsDTOList(List<OrderDetailsEntity> orderDetailsEntities){
        return modelMapper.map(orderDetailsEntities,new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }

}
