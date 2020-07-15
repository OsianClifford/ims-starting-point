package com.qa.ims.services;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orderline;

import java.util.List;

public class OrderlineServices implements CrudServices<Orderline> {

	private Dao<Orderline> orderlineDao;

	public OrderlineServices(Dao<Orderline> orderlineDao) {
		this.orderlineDao = orderlineDao;
	}

	public List<Orderline> readAll() {
		return orderlineDao.readAll();
	}

	public Orderline create(Orderline order) {
		return orderlineDao.create(orderline);
	}

	public Orderline update(Orderline order) {
		return orderlineDao.update(orderline);
	}

	public void delete(Long id) {
		orderlineDao.delete(id);
	}
}
