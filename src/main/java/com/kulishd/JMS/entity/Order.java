package com.kulishd.JMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private User user;
    private String orderNumber;
    private GoodsType type;
    private int count;

}
