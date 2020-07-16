package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Orderline;
import org.apache.log4j.Logger;

import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;


/**
 * Takes in item details for CRUD functionality
 *
 */
public class OrderlineController implements CrudController<Orderline>{

	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);

	private CrudServices<Orderline> orderlineService;

	public OrderlineController(CrudServices<Orderline> orderlineCrudServicesService){
		this.orderlineService = orderlineService;
	}
	

	Long getLongInput() {
		return Utils.getLongInput();
	}
	Double getDoubleInput() {
		return Utils.getDoubleInput();
	}

	/**
	 * Reads all orderlines to the logger
	 */
	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderline = orderlineService.readAll();
		for(Orderline orderline_loop: orderline) {
			LOGGER.info(orderline_loop.toString());
		}
		return orderline;
	}

	/**
	 * Creates an orderline by taking in user input
	 */
	@Override
	public Orderline create() {
		LOGGER.info("Please enter customerID");
		Long customerID = getLongInput();
		LOGGER.info("Please enter itemID");
		Long itemID = getLongInput();
		LOGGER.info("Please enter orderID");
		Long orderID = getLongInput();
		LOGGER.info("Please enter orderValue");
		Double orderValue = getDoubleInput();

		Orderline orderline = orderlineService.create(new Orderline(customerID, itemID, orderID, orderValue));
		LOGGER.info("orderline created");
		return orderline;
	}

	/**
	 * Updates an existing orderline by taking in user input
	 */
	@Override
	public Orderline update() {
		LOGGER.info("Please enter the id of the orderline you would like to update");
		Long id = Long.valueOf(getLongInput());
		LOGGER.info("Please enter a customer ID");
		Long customerID = getLongInput();
		LOGGER.info("Please enter a itemID");
		Long itemID = getLongInput();
		LOGGER.info("Please enter orderID");
		Long orderID = getLongInput();
		LOGGER.info("Please enter orderValue");
		Double orderValue = getDoubleInput();
		Orderline orderline = orderlineService.update(new Orderline(id, customerID, itemID, orderID, orderValue));
		LOGGER.info("orderline Updated");
		return orderline;
	}

	/**
	 * Deletes an existing orderline by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the orderline you would like to delete");
		Long id = Long.valueOf(getLongInput());
		orderlineService.delete(id);
	}
	
}
