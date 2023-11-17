package com.ismail.bookstore.repository;

import com.ismail.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
