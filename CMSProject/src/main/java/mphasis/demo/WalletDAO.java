package mphasis.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
	Connection connection;
	PreparedStatement pst; 
	
	
	public String deductBalance(int walletId, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set walletBalance=walletBalance-? where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletId);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	
	
	public Wallet searchWallet(int WalletId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where WalletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, WalletId);
		ResultSet rs = pst.executeQuery();
		Wallet wal = null;
		if (rs.next()) {
			wal = new Wallet();
			wal.setWalletId(rs.getInt("WalletId"));
			wal.setCustomerId(rs.getInt("CustomerId"));
			wal.setWalletName(rs.getString("WalletName"));
			wal.setWalletBalance(rs.getInt("WalletBalance"));
			
		}
		return wal;
	}
	
	public List<Wallet> showWallet() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Wallet> WalletList = new ArrayList<Wallet>();
		Wallet wal = null; 
		while(rs.next()) {
			wal = new Wallet();
			wal.setWalletId(rs.getInt("WalletId"));
			wal.setCustomerId(rs.getInt("CustomerId"));
			wal.setWalletName(rs.getString("WalletName"));
			wal.setWalletBalance(rs.getInt("WalletBalance"));		
			WalletList.add(wal);
		}
		return WalletList;
	}
}