package mphasis.demo;

public class Customer {

	   private int customerId;
	   private String customerName;
	   private String customerCity;
	   private String customerState;
	   private String customerEmail;
	   private String customerContactNo;
	   
	   public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId=customerId;
		}
		
		public String getCustomerName() {
				return customerName;
		}
		public void setCustomerName(String customerName) {
				this.customerName=customerName;
		}
		public String getCustomerCity() {
			return customerCity;
	    }
	    public void setCustomerCity(String customerCity) {
			this.customerCity=customerCity;
	    }
	    
	    public String getCustomerState() {
			return customerState;
	    }
	    public void setCustomerState(String customerState) {
			this.customerState=customerState;
	    }
	    public String getCustomerEmail() {
			return customerEmail;
	    }
	    public void setCustomerEmail(String customerEmail) {
			this.customerEmail=customerEmail;
	    }
	    public String getCustomerContactNo() {
			return customerContactNo;
	    }
	    public void setCustomerContactNo(String customerContactNo) {
			this.customerContactNo=customerContactNo;
	    }
	    
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerCity="
					+ customerCity + ", customerState=" + customerState + ", customerEmail=" + customerEmail
					+ ", customerContactNo=" + customerContactNo + "]";
		}
	
}
