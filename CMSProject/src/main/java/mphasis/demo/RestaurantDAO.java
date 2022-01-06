package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RestaurantDAO {

	Connection connection;
	PreparedStatement pst; 
	
	public int generateRestaurantId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(RestaurantId)+1 rid from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int RestaurantId = rs.getInt("rid");
		return RestaurantId;
	}
	
	public String addRestaurant(Restaurant res) throws ClassNotFoundException, SQLException {
		int rid=generateRestaurantId();
		connection = ConnectionHelper.getConnection();
		res.setRestaurantId(rid);
		String cmd = "Insert into Restaurant(RestaurantId,RestaurantName,City,Branch,Email,ContactNo )   "
				+ " values(?,?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, res.getRestaurantId());
		pst.setString(2, res.getRestaurantName());
		pst.setString(3, res.getCity());
		pst.setString(4, res.getBranch());
		pst.setString(5, res.getEmail());
		pst.setString(6, res.getContactNo());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Restaurant searchRestaurant(int RestaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant where RestaurantId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, RestaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant res = null;
		if (rs.next()) {
			res = new Restaurant();
			res.setRestaurantId(rs.getInt("RestaurantId"));
			res.setRestaurantName(rs.getString("RestaurantName"));
			res.setCity(rs.getString("City"));
			res.setBranch(rs.getString("Branch"));
			res.setEmail(rs.getString("Email"));
			res.setContactNo(rs.getString("ContactNo"));	
		}
		return res;
	}
	
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> RestaurantList = new ArrayList<Restaurant>();
		Restaurant res = null; 
		while(rs.next()) {
			res = new Restaurant();
			res.setRestaurantId(rs.getInt("RestaurantId"));
			res.setRestaurantName(rs.getString("RestaurantName"));
			res.setCity(rs.getString("City"));
			res.setBranch(rs.getString("Branch"));
			res.setEmail(rs.getString("Email"));
			res.setContactNo(rs.getString("ContactNo"));			
			RestaurantList.add(res);
		}
		return RestaurantList;
	}
}



