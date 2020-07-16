package com.qa.ims.persistence.domain;

public class Orderline {

	private Long id;
	private Long customerID;
	private Long itemID;
	private Long orderID;
	private Double orderValue;

	public Orderline(Long customerID, Long itemID, Long orderID, Double orderValue) {
		this.customerID = customerID;
		this.itemID = itemID;
		this.orderID = orderID;
		this.orderValue = orderValue;
	}

	public Orderline(Long id, Long customerID, Long itemID, Long orderID, Double orderValue) {
		this.id = id;
		this.customerID = customerID;
		this.itemID = itemID;
		this.orderID = orderID;
		this.orderValue = orderValue;
	}
	public Long getId() {return id;}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {this.itemID = itemID;}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String toString() {return "id:" + id + " customerID:" + customerID + " ItemID:" +
			itemID + " orderID:" + orderID + " orderValue:" + orderValue;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((orderValue == null) ? 0 : orderValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderline other = (Orderline) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;

		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;

		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;

		if (orderValue == null) {
			if (other.orderValue != null)
				return false;
		} else if (!orderValue.equals(other.orderValue))
			return false;

		return true;
	}

}
