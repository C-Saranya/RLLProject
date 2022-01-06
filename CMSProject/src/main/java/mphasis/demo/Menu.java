package mphasis.demo;

public class Menu {
	
	   private int restaurantId;
	   private int menuId;
	   private String itemName;
	   private String menuType;
	   private int calories;
	   private int price;
	   
	   public int getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(int restaurantId) {
			this.restaurantId=restaurantId;
		}
		
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId=menuId;
		}
		
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName=itemName;
		}
		
		public String getMenuType() {
			return menuType;
		}
		public void setMenuType(String menuType) {
			this.menuType=menuType;
		}
		
		public int getCalories() {
			return calories;
		}
		public void setCalories(int calories) {
			this.calories=calories;
		}
		
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price=price;
		}
		
		@Override
		public String toString() {
			return "Menu [restaurantId=" + restaurantId + ", menuId=" + menuId + ", itemName=" + itemName
					+ ", menuType=" + menuType + ", calories=" + calories + ", price=" + price + "]";
		}
		
}
