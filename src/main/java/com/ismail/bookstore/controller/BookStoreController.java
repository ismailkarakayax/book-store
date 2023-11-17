package com.ismail.bookstore.controller;

import com.ismail.bookstore.dto.BookOrderRequest;
import com.ismail.bookstore.model.Order;
import com.ismail.bookstore.repository.OrderRepository;
import com.ismail.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    //localhost:8080/v1/bookstore
    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");

    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order= orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }


}
