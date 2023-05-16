package com.psk.eshop.service;

import com.psk.eshop.dto.OrderFilterDTO;
import com.psk.eshop.dto.OrderRequestDTO;
import com.psk.eshop.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequestDTO order);
    List<Order> getOrders();
    Order getOrderById(Long orderId);
    Order updateOrder(Long orderId, OrderRequestDTO orderRequest);
    List<Order> filterOrders(OrderFilterDTO orderFilter);
    void deleteOrderById(Long orderId);
}
