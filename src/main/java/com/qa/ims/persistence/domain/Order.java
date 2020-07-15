package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	//private Long itemId;
	private String orderDate;
	//private Double orderValue;

	public Order(Long customerId, String orderDate) {
		this.customerId = customerId;
		//this.itemId = itemId;
		this.orderDate = orderDate;
		//this.orderValue = orderValue;
	}

	public Order(Long id, Long customerId, String orderDate) {
		this.id = id;
		this.customerId = customerId;
		//this.itemId = itemId;
		this.orderDate = orderDate;
		//this.orderValue = orderValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	//public Long getItemId() {
	//	return itemId;
	//}

	//public void setItemId(Long itemId) {
	//	this.itemId = itemId;
	//}

	public String getOrderDate() {return orderDate;}

	public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

	//public Double getOrderValue() {
	//	return orderValue;
	//}

	//public void setOrderValue(Double orderValue) {
	//	this.orderValue = orderValue;
	//}

	public String toString() {
		return "id:" + id + " customer ID:" + customerId + /*" item ID:" + itemId +*/ "order date:" + orderDate /*+ "order value:" + orderValue*/;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		//result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		//result = prime * result + ((orderValue == null) ? 0 : itemValue.hashCode());
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
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		//if (itemId == null) {
		//	if (other.itemId != null)
		//		return false;
		//} else if (!itemId.equals(other.itemId))
		//	return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		return true;
		//if (orderValue == null) {
		//	if (other.orderValue != null)
		//		return false;
		//} else if (!orderValue.equals(other.orderValue))
		//	return false;
		//return true;
	}

}
