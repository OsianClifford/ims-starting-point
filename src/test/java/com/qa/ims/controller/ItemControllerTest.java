package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item
	 * controller
	 */
	@Spy // for the methods in itemController
	@InjectMocks // for any classes our itemController calls (in this case itemService)
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items .add(new Item(1L, "item1", 10.0));
		items .add(new Item(2L, "item2", 2.0));
		items .add(new Item(3L, "item3", 5.0));
		Mockito.when(itemServices.readAll()).thenReturn(items );
		assertEquals(items , itemController.readAll());
	}

//	@Test
//	public void createTest() {
//		String itemName = "item1";
//		Double itemValue = 10.0;
//		Mockito.doReturn(itemName, itemValue).when(itemController).getInput();
//		Item item = new Item(itemName, itemValue);
//		Item savedItem = new Item(1L, "item1", 10.0);
//		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
//		assertEquals(savedItem, itemController.create());
//	}

	/**
	 *
	 */
//	@Test
//	public void updateTest() {
//		String id = "1";
//		String itemName = "Item1";
//		Double itemValue = 10.0;
//		Mockito.doReturn(id, itemName, itemValue).when(itemController).getInput();
//		Item item = new Item(1L, itemName, itemValue);
//		Mockito.when(itemServices.update(item)).thenReturn(item);
//		assertEquals(item, itemController.update());
//	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
//		@Test
//		public void deleteTest() {
//			String id = "1";
//			Mockito.doReturn(id).when(itemController).getInput();
//			itemController.delete();
//			Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
//		}

}
