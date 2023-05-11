package com.psk.eshop.service;

import com.psk.eshop.dto.OrderRequestDTO;
import com.psk.eshop.model.Order;
import com.psk.eshop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(OrderRequestDTO orderRequest) {
        var newOrder = Order.builder()
                .userId(orderRequest.getUserId())
                .orderStatus(orderRequest.getOrderStatus())
                .price(orderRequest.getPrice())
                .shippingAddress(orderRequest.getShippingAddress())
                .build();
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Order with id %d not found", orderId))
        );
    }
    @Override
    public Order updateOrder(Long orderId, OrderRequestDTO orderRequest) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setUserId(orderRequest.getUserId());
                    order.setOrderStatus(orderRequest.getOrderStatus());
                    order.setPrice(orderRequest.getPrice());
                    order.setShippingAddress(orderRequest.getShippingAddress());
                    return orderRepository.save(order);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Order with id %d not found", orderId))
                );
    }
}
