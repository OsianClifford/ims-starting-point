package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Order;
import org.apache.log4j.Logger;

import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}


	String getInput() {
		return Utils.getInput();
	}
	Long getLongInput() {
		return Utils.getLongInput();
	}
	Double getDoubleInput() {
		return Utils.getDoubleInput();
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> item = orderService.readAll();
		for(Order order_loop: item) {
			LOGGER.info(order_loop.toString());
		}
		return item;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {

		LOGGER.info("Please enter customer ID who made the order");
		Long customerID = getLongInput();
		//LOGGER.info("Please enter item ID that they ordered");
		//Long itemID = getLongInput();
		LOGGER.info("Please enter order date");
		String orderDate = getInput();
		//LOGGER.info("Please enter order value");
		//Double orderValue = getDoubleInput();
		Order order = orderService.create(new Order(customerID, /*itemID,*/ orderDate/*, orderValue*/));
		LOGGER.info("order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer ID");
		Long customerID = Long.valueOf(getInput());
		//LOGGER.info("Please enter a item ID");
		//Long itemID = Long.valueOf(getInput());
		LOGGER.info("Please enter a date");
		String orderDate = String.valueOf(getInput());
		//LOGGER.info("Please enter a order value");
		//Double orderValue = Double.valueOf(getInput());

		Order order = orderService.update(new Order(id, customerID, /*itemID,*/ orderDate/*, orderValue*/));
		LOGGER.info("order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
	}
	
}
