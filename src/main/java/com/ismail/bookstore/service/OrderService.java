package com.ismail.bookstore.service;

import com.ismail.bookstore.model.Book;
import com.ismail.bookstore.model.Order;
import com.ismail.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAnOrder(List<Integer> bookIdList,String userName){
        // Veritabanında var olan kitapları filtrele
        List<Book> bookList = bookIdList.stream()
                .map(bookService::findBookById)
                .toList();

        Double totalPrice = bookList.stream()
                .map(Book::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);

        Order order = Order.builder()
                .bookList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        return orderRepository.save(order);
    }
}