package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst; 
	
	public int generateVendorId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(VendorId)+1 vid from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int VendorId = rs.getInt("vid");
		return VendorId;
	}
	
	public String addVendor(Vendor ven) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int vid=generateVendorId();
		ven.setVendorId(vid);
		String cmd = "Insert into Vendor(VendorId,VendorName,VendorCity,VendorState,VendorEmail,VendorContactNo)   "
				+ " values(?,?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, ven.getVendorId());
		pst.setString(2, ven.getVendorName());
		pst.setString(3, ven.getVendorCity());
		pst.setString(4, ven.getVendorState());
		pst.setString(5, ven.getVendorEmail());
		pst.setString(6, ven.getVendorContactNo());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	
	public Vendor searchVendor(int VendorId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor where VendorId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, VendorId);
		ResultSet rs = pst.executeQuery();
		Vendor ven = null;
		if (rs.next()) {
			ven = new Vendor();
			ven.setVendorId(rs.getInt("VendorId"));
			ven.setVendorName(rs.getString("VendorName"));
			ven.setVendorCity(rs.getString("VendorCity"));
			ven.setVendorState(rs.getString("VendorState"));
			ven.setVendorEmail(rs.getString("VendorEmail"));
			ven.setVendorContactNo(rs.getString("VendorContactNo"));	
		}
		return ven;
	}
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vendor> VendorList = new ArrayList<Vendor>();
		Vendor ven = null; 
		while(rs.next()) {
			ven = new Vendor();
			ven.setVendorId(rs.getInt("VendorId"));
			ven.setVendorName(rs.getString("VendorName"));
			ven.setVendorCity(rs.getString("VendorCity"));
			ven.setVendorState(rs.getString("VendorState"));
			ven.setVendorEmail(rs.getString("VendorEmail"));
			ven.setVendorContactNo(rs.getString("VendorContactNo"));			
			VendorList.add(ven);
		}
		return VendorList;
	}
}
