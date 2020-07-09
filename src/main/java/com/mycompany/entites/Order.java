package com.mycompany.entites;

import java.math.BigDecimal;

public class Order extends BaseEntity{
    private Table table;

    private Article article;

    private Integer quantity;

    private OrderStatus status;

    private BigDecimal totalPrice;
}
