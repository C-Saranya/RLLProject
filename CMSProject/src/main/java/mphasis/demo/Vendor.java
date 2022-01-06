package mphasis.demo;

public class Vendor {
	
	   private int vendorId;
	   private String vendorName;
	   private String vendorCity;
	   private String vendorState;
	   private String vendorEmail;
	   private String vendorContactNo;
	   
	   public int getVendorId() {
			return vendorId;
		}
		public void setVendorId(int vendorId) {
			this.vendorId=vendorId;
		}
		
		public String getVendorName() {
				return vendorName;
		}
		public void setVendorName(String vendorName) {
				this.vendorName=vendorName;
		}
		public String getVendorCity() {
			return vendorCity;
	    }
	    public void setVendorCity(String vendorCity) {
			this.vendorCity=vendorCity;
	    }
	    
	    public String getVendorState() {
			return vendorState;
	    }
	    public void setVendorState(String vendorState) {
			this.vendorState=vendorState;
	    }
	    public String getVendorEmail() {
			return vendorEmail;
	    }
	    public void setVendorEmail(String vendorEmail) {
			this.vendorEmail=vendorEmail;
	    }
	    public String getVendorContactNo() {
			return vendorContactNo;
	    }
	    public void setVendorContactNo(String vendorContactNo) {
			this.vendorContactNo=vendorContactNo;
	    }
	    
		@Override
		public String toString() {
			return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorCity=" + vendorCity
					+ ", vendorState=" + vendorState + ", vendorEmail=" + vendorEmail + ", vendorContactNo="
					+ vendorContactNo + "]";
		}
	        
}
