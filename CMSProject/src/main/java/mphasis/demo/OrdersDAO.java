package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDAO {

	Connection connection;
	PreparedStatement pst;
	
	public Orders searchOrder(int OrderId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  OrderId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, OrderId);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		if (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("OrderId"));
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setVendorId(rs.getInt("VendorID"));
			order.setMenuId(rs.getInt("MenuId"));
			order.setWalletId(rs.getInt("WalletId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setOrderStatus(rs.getString("OrderStatus"));
			order.setQuantityOrdered(rs.getInt("QuantityOrdered"));
			order.setBillAmount(rs.getInt("BillAmount"));
			order.setComments(rs.getString("Comments"));
		}
		return order;
	}
	
	public List<Orders> customerOrders(int CustomerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  CustomerId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, CustomerId);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders order = null;
		while (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("OrderId"));
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setVendorId(rs.getInt("VendorID"));
			order.setMenuId(rs.getInt("MenuId"));
			order.setWalletId(rs.getInt("WalletId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setOrderStatus(rs.getString("OrderStatus"));
			order.setQuantityOrdered(rs.getInt("QuantityOrdered"));
			order.setBillAmount(rs.getInt("BillAmount"));
			order.setComments(rs.getString("Comments"));
			OrdersList.add(order);
		}
		return OrdersList;
	}
	
	public List<Orders> vendorOrders(int VendorId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  VendorId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, VendorId);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders order = null;
		while (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("OrderId"));
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setVendorId(rs.getInt("VendorID"));
			order.setMenuId(rs.getInt("MenuId"));
			order.setWalletId(rs.getInt("WalletId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setOrderStatus(rs.getString("OrderStatus"));
			order.setQuantityOrdered(rs.getInt("QuantityOrdered"));
			order.setBillAmount(rs.getInt("BillAmount"));
			order.setComments(rs.getString("Comments"));
			OrdersList.add(order);
		}
		return OrdersList;
	}
	
	public Orders customerPendingOrders(int CustomerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  CustomerId=? and OrderStatus='PENDING' ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, CustomerId);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		if (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("OrderId"));
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setVendorId(rs.getInt("VendorID"));
			order.setMenuId(rs.getInt("MenuId"));
			order.setWalletId(rs.getInt("WalletId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setOrderStatus(rs.getString("OrderStatus"));
			order.setQuantityOrdered(rs.getInt("QuantityOrdered"));
			order.setBillAmount(rs.getInt("BillAmount"));
			order.setComments(rs.getString("Comments"));
		}
		return order;
	}
	
	public Orders vendorPendingOrders(int VendorId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where  VendorId=? and OrderStatus='PENDING' ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, VendorId);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		if (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("OrderId"));
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setVendorId(rs.getInt("VendorID"));
			order.setMenuId(rs.getInt("MenuId"));
			order.setWalletId(rs.getInt("WalletId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setOrderStatus(rs.getString("OrderStatus"));
			order.setQuantityOrdered(rs.getInt("QuantityOrdered"));
			order.setBillAmount(rs.getInt("BillAmount"));
			order.setComments(rs.getString("Comments"));
		}
		return order;
	}
	
	public String acceptOrRejectOrder(int OrderId, int VendorId, String Status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Orders order = searchOrder(OrderId);
		if (order.getVendorId()==VendorId) {
			if (Status.toUpperCase().equals("YES")) {
				String cmd = "Update Orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, OrderId);
				pst.executeUpdate();
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update Orders set OrderStatus='REJECTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, OrderId);
				pst.executeUpdate();
				cmd = "Update Wallet set WalletBalance=WalletBalance+? where WalletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getWalletId());
				pst.executeUpdate();
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are Unauthorized Vendor...";
	}
	
	
	public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getPrice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchWallet(order.getWalletId());
		int amount = wallet.getWalletBalance();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(OrderId,CustomerId,VendorId,WalletID,MenuId,OrderDate,OrderStatus,QuantityOrdered,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getCustomerId());
			pst.setInt(3, order.getVendorId());
			pst.setInt(4, order.getWalletId());
			pst.setInt(5, order.getMenuId());
			pst.setDate(6, (java.sql.Date) order.getOrderDate()); 
			pst.setString(7, order.getOrderStatus());
			pst.setInt(8, order.getQuantityOrdered());
			pst.setInt(9, order.getBillAmount());
			pst.setString(10, order.getComments());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(OrderId) is NULL THEN 1"
				+ " else max(OrderId)+1 end oid from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}
}
