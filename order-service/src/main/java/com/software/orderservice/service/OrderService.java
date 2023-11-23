package com.software.orderservice.service;

import com.software.orderservice.dto.OrderLineItemsDTO;
import com.software.orderservice.dto.OrderRequest;
import com.software.orderservice.model.Order;
import com.software.orderservice.model.OrderLineItems;
import com.software.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItems().stream().map(this::mapToDto).collect(Collectors.toList());
        order.setOrderLineItems(orderLineItemsList);
        return orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        BeanUtils.copyProperties(orderLineItemsDTO, orderLineItems);
        return orderLineItems;
    }

    public List<Order> getOrder() {
        List<Order> orderList = new ArrayList<>();
        Iterable<Order> orders = orderRepository.findAll();
        orders.forEach(orderList::add);
        return orderList;
    }

    public Order getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.orElse(new Order());
    }
}
