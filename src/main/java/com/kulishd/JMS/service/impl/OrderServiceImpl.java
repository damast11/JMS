package com.kulishd.JMS.service.impl;

import com.kulishd.JMS.entity.jms.Sender;
import com.kulishd.JMS.service.ConsoleService;
import com.kulishd.JMS.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ConsoleService consoleService;
    private final Sender sender;

    private static final String ORDER_QUEUE = "order-queue";

    @Override
    public void sendOrderToProcess() {
        var order = consoleService.readFromConsole();
        sender.sendMessage(ORDER_QUEUE, order);
    }
}
