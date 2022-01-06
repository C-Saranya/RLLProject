package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
		Connection connection;
		PreparedStatement pst; 
		
		public int generateCustomerId() throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select max(CustomerId)+1 cid from Customer";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			rs.next();
			int CustomerId = rs.getInt("cid");
			return CustomerId;
		}
		
		public String addCustomer(Customer cus) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			int cid=generateCustomerId();
			cus.setCustomerId(cid);
			String cmd = "Insert into Customer(CustomerId,CustomerName,CustomerCity,CustomerState,CustomerEmail,CustomerContactNo)   "
					+ " values(?,?,?,?,?,?) ";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, cus.getCustomerId());
			pst.setString(2, cus.getCustomerName());
			pst.setString(3, cus.getCustomerCity());
			pst.setString(4, cus.getCustomerState());
			pst.setString(5, cus.getCustomerEmail());
			pst.setString(6, cus.getCustomerContactNo());
			pst.executeUpdate();
			return "Record Inserted...";
		}
		
		
		public Customer searchCustomer(int CustomerId) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select * from Customer where CustomerId=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, CustomerId);
			ResultSet rs = pst.executeQuery();
			Customer cus = null;
			if (rs.next()) {
				cus = new Customer();
				cus.setCustomerId(rs.getInt("CustomerId"));
				cus.setCustomerName(rs.getString("CustomerName"));
				cus.setCustomerCity(rs.getString("CustomerCity"));
				cus.setCustomerState(rs.getString("CustomerState"));
				cus.setCustomerEmail(rs.getString("CustomerEmail"));
				cus.setCustomerContactNo(rs.getString("CustomerContactNo"));	
			}
			return cus;
		}
		
		public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select * from Customer";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<Customer> CustomerList = new ArrayList<Customer>();
			Customer cus = null; 
			while(rs.next()) {
				cus = new Customer();
				cus.setCustomerId(rs.getInt("CustomerId"));
				cus.setCustomerName(rs.getString("CustomerName"));
				cus.setCustomerCity(rs.getString("CustomerCity"));
				cus.setCustomerState(rs.getString("CustomerState"));
				cus.setCustomerEmail(rs.getString("CustomerEmail"));
				cus.setCustomerContactNo(rs.getString("CustomerContactNo"));				
				CustomerList.add(cus);
			}
			return CustomerList;
		}
	}
