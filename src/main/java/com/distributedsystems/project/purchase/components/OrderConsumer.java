package com.distributedsystems.project.purchase.components;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.distributedsystems.project.purchase.entities.Customer;
import com.distributedsystems.project.purchase.entities.Order;
import com.distributedsystems.project.purchase.entities.OrderItem;
import com.distributedsystems.project.purchase.repositories.OrdersRepository;
import com.distributedsystems.project.purchase.services.EmailService;

@Component
public class OrderConsumer {
	
	private static final Log LOG = LogFactory.getLog(OrderConsumer.class);
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ProcessingOrderMailBuilder processingOrderMailBuilder;
	
	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues= { "orders" })
	public void receive(@Payload byte[] payload) {
		String orderId = new String(payload);
		
		LOG.info("Processing order with id '" + orderId + "'");
		
		Optional<Order> order = ordersRepository.findById(Integer.parseInt(orderId));
		
		if(order.isPresent()) {
			printOrderLog(order.get());
			sendOrderProcessingEmail(order.get());
			
		} else {
			LOG.info("Order not founded! ");
		}
	}
	
	
	private void printOrderLog(Order order) {
		
		LOG.info("Order founded! ");
		LOG.info("OrderDate = " + order.getOrderDate());
		LOG.info("TotalAmount = " + order.getTotalAmount());
		LOG.info("OrderNumber = " + order.getOrderNumber());
		
		Customer customer = order.getCustomer();
		
		LOG.info("Customer = " + customer.getFirstName() + " " + customer.getLastName());
		
		
		LOG.info("Items: ");
		List<OrderItem> orderItems = order.getItems();
		
		for(OrderItem orderItem : orderItems) {
			LOG.info(" - " + orderItem.getProduct().getProductName() + ", " + orderItem.getUnitPrice() + ", " + orderItem.getQuantity());
		}
		
		LOG.info("Total amount: " + order.getTotalAmount());
	
	}
	
	private void sendOrderProcessingEmail(Order order) {
		Optional<String> email = Optional.of(order.getCustomer().getEmail());

		email.ifPresent(customerEmail -> {
			String subject = "[Store] La orden de compra '" + order.getId() + "' está siendo procesada";

			processingOrderMailBuilder.withTemplate("email/order_processing")
					.withOrder(order);

			String text = processingOrderMailBuilder.build();
			emailService.sendEmail(customerEmail, subject, text);
		});
	}
}
