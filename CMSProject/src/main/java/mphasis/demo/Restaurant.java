package mphasis.demo;

public class Restaurant {
	
	private int restaurantId;
	private String restaurantName;
	private String city;
	private String branch;
	private String email;
	private String contactNo; 
	

	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId=restaurantId;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName=restaurantName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch=branch;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo=contactNo;
	}
	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", city=" + city
				+ ", branch=" + branch + ", email=" + email + ", contactNo=" + contactNo + "]";
	}
	
}
