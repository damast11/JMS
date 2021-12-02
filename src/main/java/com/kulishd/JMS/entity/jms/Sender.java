package com.kulishd.JMS.entity.jms;

import com.kulishd.JMS.entity.GoodsType;
import com.kulishd.JMS.entity.Order;
import com.kulishd.JMS.entity.SummaryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String destination, Order order){
        if (GoodsType.LIQUID.equals(order.getType())) {
            jmsTemplate.convertAndSend(destination, order, message -> {
                message.setStringProperty("type", "liquid");
                return message;
            });
        }
            else {
            jmsTemplate.convertAndSend(destination, order, message -> {
                message.setStringProperty("type", "countable");
                return message;
            });
        }
    }

    public void sendMessage(String destination, SummaryInfo summaryInfo){
        jmsTemplate.convertAndSend(destination, summaryInfo);
    }
}
