package com.kulishd.JMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryInfo {

    private Order order;
    private Status status;
}
