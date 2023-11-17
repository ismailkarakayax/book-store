package com.ismail.bookstore.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class BookOrderRequest {
    private List<Integer> bookIdList;
    private String userName;


}
