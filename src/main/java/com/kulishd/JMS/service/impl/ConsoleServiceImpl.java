package com.kulishd.JMS.service.impl;

import java.util.Scanner;

import com.kulishd.JMS.entity.GoodsType;
import com.kulishd.JMS.entity.Order;
import com.kulishd.JMS.entity.User;
import com.kulishd.JMS.service.ConsoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsoleServiceImpl implements ConsoleService {

    @Override
    public Order readFromConsole() {
        var in = new Scanner(System.in);
        log.info("Please enter user");
        var userName = in.nextLine();
        log.info("Please enter order number");
        var orderNumber = in.nextLine();
        log.info("Please enter type (LIQUID or COUNTABLE)");
        var type = in.nextLine();
        log.info("Please enter count");
        var count = in.nextInt();
        in.close();

        return new Order(new User(userName), orderNumber, GoodsType.valueOf(type), count);
    }
}
