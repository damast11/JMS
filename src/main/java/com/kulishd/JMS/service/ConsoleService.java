package com.kulishd.JMS.service;

import com.kulishd.JMS.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface ConsoleService {

    Order readFromConsole();
}
