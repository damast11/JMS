package com.kulishd.JMS;

import com.kulishd.JMS.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
@Slf4j
public class JmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(JmsApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		log.info("Please input parameters");
		orderService.sendOrderToProcess();
	}

}
