package com.distributedsystems.project.purchase;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
public class PurchaseApplication {

	@Value("${queue.name}")
    private String ordersQueue;
	
	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(ordersQueue, true);
    }

}
