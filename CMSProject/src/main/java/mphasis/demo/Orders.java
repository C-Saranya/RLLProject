package mphasis.demo;

import java.util.Date;

public class Orders {
	
	private int orderId;
	private int customerId;
	private int vendorId;
	private int walletId;
	private int menuId;
	private Date orderDate;
	private String orderStatus;
	private int quantityOrdered;
	private int billAmount;
	private String comments;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", vendorId=" + vendorId + ", walletId="
				+ walletId + ", menuId=" + menuId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", quantityOrdered=" + quantityOrdered + ", billAmount=" + billAmount + ", comments="
				+ comments + "]";
	}

}
