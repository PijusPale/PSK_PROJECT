package com.psk.eshop.controller;

import com.psk.eshop.dto.OrderRequestDTO;
import com.psk.eshop.model.Order;
import com.psk.eshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public String add(@RequestBody OrderRequestDTO order){
        orderService.createOrder(order);
        return "new order is added!";
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/order/{orderId}")
    public Order update(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequest){
        return orderService.updateOrder(orderId, orderRequest);
    }
}
