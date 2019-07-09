package com.distributedsystems.project.purchase.components;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.distributedsystems.project.purchase.entities.Order;
import com.distributedsystems.project.purchase.repositories.OrdersRepository;

@Component
public class OrderConsumer {
	
	private static final Log LOG = LogFactory.getLog(OrderConsumer.class);
	
	@Autowired
	private OrdersRepository ordersRepository;

	@RabbitListener(queues= { "orders" })
	public void receive(@Payload byte[] payload) {
		String orderId = new String(payload);
		LOG.info("Processing order with id '" + orderId + "'");
		
		Optional<Order> order = ordersRepository.findById(Integer.parseInt(orderId));
		if(order.isPresent()) {
			LOG.info("Order founded! ");
			LOG.info("OrderDate = " + order.get().getOrderDate());
			LOG.info("TotalAmount = " + order.get().getTotalAmount());
			LOG.info("OrderNumber = " + order.get().getOrderNumber());
		} else {
			LOG.info("Order not founded! ");
		}
	}
}
