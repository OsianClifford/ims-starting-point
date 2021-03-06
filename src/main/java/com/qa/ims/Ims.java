package com.qa.ims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import org.apache.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.ItemServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.utils.Utils;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	Domain domain = null;
	Action action = null;

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInput();

		init(username, password);

		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();
		domain = Domain.getDomain();

		action = null;
		while(true) {
			do {
				LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
				Action.printActions();
				action = Action.getAction();

				switch (domain) {
					case CUSTOMER:
						CustomerController customerController = new CustomerController(new CustomerServices
								(new CustomerDaoMysql(username, password)));
						doAction(customerController, action);
						break;
					case ITEM:
						ItemController itemController = new ItemController(new ItemServices
								(new ItemDaoMysql(username, password)));
						doAction(itemController, action);
						break;
					case ORDER:
						OrderController orderController = new OrderController(new OrderServices
								(new OrderDaoMysql(username, password)));
						doAction(orderController, action);
						break;
					case STOP:
						System.exit(0);
						break;
					default:
						break;
				}
			} while (action != Action.RETURN);
		}
	}


	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();
			domain = Domain.getDomain();
			break;
		default:
			break;
		}
	}

	/**
	 * To initialise the database schema. DatabaseConnectionUrl will default to
	 * localhost.
	 *
	 * @param username
	 * @param password
	 */
	public void init(String username, String password) {
		init("jdbc:mysql://" + Utils.MYSQL_URL + "/ims?serverTimezone=UTC", username, password, "src/main/resources/sql-schema.sql");
	}

	public String readFile(String fileLocation) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				stringBuilder.append(string);
				stringBuilder.append("\r\n");
			}
		} catch (IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
		return stringBuilder.toString();
	}

	/**
	 * To initialise the database with the schema needed to run the application
	 */
	public void init(String jdbcConnectionUrl, String username, String password, String fileLocation) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
	}

}
