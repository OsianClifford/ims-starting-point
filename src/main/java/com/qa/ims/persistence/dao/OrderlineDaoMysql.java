package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.utils.Utils;

public class OrderlineDaoMysql implements Dao<Orderline> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderlineDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims?serverTimezone=UTC";
		this.username = username;
		this.password = password;
	}

	public OrderlineDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orderline orderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("orderline_id");
		Long customerID = resultSet.getLong("customer_id");
		Long itemID = resultSet.getLong("item_id");
		Long orderID = resultSet.getLong("order_id");
		return new Orderline(id, customerID, itemID, orderID);
	}

	/**
	 * Reads all orderlines from the database
	 *
	 * @return A list of orderlines
	 */
	@Override
	public List<Orderline> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderline");) {
			ArrayList<Orderline> orderline = new ArrayList<>();
			while (resultSet.next()) {
				orderline.add(orderlineFromResultSet(resultSet));
			}
			return orderline;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orderline readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline ORDER BY orderline_id DESC LIMIT 1");) {
			resultSet.next();
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an orderline in the database
	 *
	 * @param orderline - takes in an orderline object. id will be ignored
	 */
	@Override
	public Orderline create(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orderline(customer_id, item_id, order_id) values('" + orderline.getCustomerID()
					+ "','" + orderline.getItemID() + "','" + orderline.getOrderID() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orderline readOrderline(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM orderline where orderline_id = " + id);) {
			resultSet.next();
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an orderline in the database
	 *
	 * @param orderline - takes in an orderline object, the id field will be used to
	 *                 update that orderline in the database
	 * @return
	 */
	@Override
	public Orderline update(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orderline set customer_id ='" + orderline.getCustomerID() + "', item_id ='"
					+ orderline.getItemID() + "', order_id ='" + orderline.getOrderID());
			return readOrderline(orderline.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an orderline in the database
	 *
	 * @param id - id of the orderline
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orderline where orderline_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
