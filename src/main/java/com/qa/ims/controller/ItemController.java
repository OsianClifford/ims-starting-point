package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.domain.Item;
import org.apache.log4j.Logger;

import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;


/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item>{

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
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
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> item = itemService.readAll();
		for(Item item_loop: item) {
			LOGGER.info(item_loop.toString());
		}
		return item;
	}

	/**
	 * Creates a item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String itemName = getInput();
		LOGGER.info("Please enter item value");
		Double itemValue = getDoubleInput();
		Item item = itemService.create(new Item(itemName, itemValue));
		LOGGER.info("item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter an item name");
		String itemName = getInput();
		LOGGER.info("Please enter an item value");
		Double itemValue = getDoubleInput();
		Item item = itemService.update(new Item(id, itemName, itemValue));
		LOGGER.info("item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getLongInput());
		itemService.delete(id);
	}
	
}
