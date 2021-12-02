package com.kulishd.JMS.entity.jms;

import com.kulishd.JMS.entity.Order;
import com.kulishd.JMS.entity.Status;
import com.kulishd.JMS.entity.SummaryInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SecondApp {

    private final Sender sender;

    private static final int THRESHOLD = 100;
    private static final int LITERS = 50;

    @JmsListener(destination = "order-queue", containerFactory = "myFactory",
    selector = "type = 'liquid'")
    public void receiveLiquid(Order order) {
        var summaryInfo = new SummaryInfo();
        summaryInfo.setOrder(order);
        log.info("Order Recieved = " + order);
        if (order.getCount() < LITERS) {
            log.info("Order " + order.getOrderNumber() + " completed");
            summaryInfo.setStatus(Status.COMPLETED);
        } else {
            log.info("Order " + order.getOrderNumber() + " rejected");
            summaryInfo.setStatus(Status.REJECTED);
        }
        sender.sendMessage("summary-queue", summaryInfo);
        log.info("message sent");
    }

    @JmsListener(destination = "order-queue", containerFactory = "myFactory",
        selector = "type = 'countable'")
    public void receiveCountable(Order order) {
        var summaryInfo = new SummaryInfo();
        summaryInfo.setOrder(order);
        log.info("Order Recieved = " + order);
        if (order.getCount() < THRESHOLD) {
            log.info("Order " + order.getOrderNumber() + " completed");
            summaryInfo.setStatus(Status.COMPLETED);
        } else {
            log.info("Order " + order.getOrderNumber() + " rejected");
            summaryInfo.setStatus(Status.REJECTED);
        }
        sender.sendMessage("summary-queue", summaryInfo);
        log.info("message sent");
    }
}
