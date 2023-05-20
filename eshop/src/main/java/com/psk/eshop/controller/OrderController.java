package com.psk.eshop.controller;

import com.psk.eshop.dto.OrderFilterDTO;
import com.psk.eshop.dto.OrderRequestDTO;
import com.psk.eshop.model.Order;
import com.psk.eshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin("*")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public Order add(@RequestBody OrderRequestDTO order){
        return orderService.createOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders/filter")
    public List<Order> filterOrders(OrderFilterDTO orderFilter){
        return orderService.filterOrders(orderFilter);
    }

    @PutMapping("/order/{orderId}")
    public Order update(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequest){
        return orderService.updateOrder(orderId, orderRequest);
    }
    @DeleteMapping("/order/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId)
    {
        orderService.deleteOrderById(orderId);
    }
}
