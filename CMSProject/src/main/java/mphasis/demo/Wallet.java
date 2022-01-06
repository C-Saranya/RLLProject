package mphasis.demo;

public class Wallet {
	
	   private int customerId;
	   private int walletId;
	   private String walletName;
	   private int walletBalance;
	  
	   
	public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId=customerId;
		}
		
		public int getWalletId() {
				return walletId;
		}
		public void setWalletId(int walletId) {
				this.walletId=walletId;
		}
		public String getWalletName() {
				return walletName;
		}
		public void setWalletName(String walletName) {
				this.walletName=walletName;
		}
		 public int getWalletBalance() {
				return walletBalance;
		}
		public void setWalletBalance(int walletBalance) {
				this.walletBalance=walletBalance;
		}
		
		
		@Override
		public String toString() {
			return "Wallet [customerId=" + customerId + ", walletId=" + walletId + ", walletName=" + walletName
					+ ", walletBalance=" + walletBalance + "]";
		}
		
		
		
}
