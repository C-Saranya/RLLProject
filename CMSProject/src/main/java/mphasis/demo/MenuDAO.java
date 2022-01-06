package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MenuDAO {
	
	Connection connection;
	PreparedStatement pst; 
	
	
	public int generateMenuId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(MenuId)+1 mid from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int MenuId = rs.getInt("mid");
		return MenuId;
	}
	
	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int mid=generateMenuId();
		menu.setMenuId(mid);
		String cmd = "Insert into Menu(RestaurantId,MenuId,ItemName,MenuType,Calories,Price)   "
				+ " values(?,?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menu.getRestaurantId());
		pst.setInt(2, menu.getMenuId());
		pst.setString(3, menu.getItemName());
		pst.setString(4, menu.getMenuType());
		pst.setInt(5, menu.getCalories());
		pst.setInt(6, menu.getPrice());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Menu searchMenu(int MenuId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu where MenuId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, MenuId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if (rs.next()) {
			menu = new Menu();
			menu.setRestaurantId(rs.getInt("RestaurantId"));
			menu.setMenuId(rs.getInt("MenuId"));
			menu.setItemName(rs.getString("ItemName"));
			menu.setMenuType(rs.getString("Menutype"));
			menu.setCalories(rs.getInt("Calories"));
			menu.setPrice(rs.getInt("Price"));
		}
		return menu;
	}
	
	public List<Menu> showMenu(int RestaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu where RestaurantId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, RestaurantId);
		ResultSet rs = pst.executeQuery();
		List<Menu> MenuList = new ArrayList<Menu>();
		Menu menu = null; 
		while(rs.next()) {
			menu = new Menu();
			menu.setRestaurantId(rs.getInt("RestaurantId"));
			menu.setMenuId(rs.getInt("MenuId"));
			menu.setItemName(rs.getString("ItemName"));
			menu.setMenuType(rs.getString("Menutype"));
			menu.setCalories(rs.getInt("Calories"));
			menu.setPrice(rs.getInt("Price"));		
			MenuList.add(menu);
		}
		return MenuList;
	}

}
