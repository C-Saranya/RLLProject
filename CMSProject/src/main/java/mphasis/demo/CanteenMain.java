package mphasis.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CanteenMain {

static Scanner sc =  new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("---------------");
			System.out.println("1. Show Restaurant ");
			System.out.println("2. Search Restaurant");
			System.out.println("3. Add Restaurant");
			System.out.println("4. Show Menu");
			System.out.println("5. Search Menu");
			System.out.println("6. Add Menu");
			System.out.println("7. Show Customer");
			System.out.println("8. Search Customer");
			System.out.println("9. Add Customer");
			System.out.println("10. Show Vendor");
			System.out.println("11. Search Vendor");
			System.out.println("12. Add Vendor");
			System.out.println("13. Show Wallet");
			System.out.println("14. Search Wallet");
			System.out.println("15. Place Order");
			System.out.println("16. Accept Or Reject Order");
			System.out.println("17. Customer Orders");
			System.out.println("18. Customer Pending Orders");
			System.out.println("19. Vendor Orders");
			System.out.println("20. Vendor Pending Orders");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
		case 1 : 
			showRestaurant();
			break;
		case 2 : 
			try {
				searchRestaurant();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			addRestaurant();
			break;
		case 4:
			showMenu();
			break;		
		case 5: 
			try {
				searchMenu();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			addMenu();
			break;
		case 7:
			showCustomer();
			break;		
		case 8: 
			try {
				searchCustomer();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 9:
			addCustomer();
			break;
		case 10:
			showVendor();
			break;		
		case 11: 
			try {
				searchVendor();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 12:
			addVendor();
			break;
		case 13:
			showWallet();
			break;		
		case 14: 
			try {
				searchWallet();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 15:
			try {
				placeOrder();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 16 : 
			try {
				acceptOrReject();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case 17:
				customerOrders();
				break;
		case 18:
				try {
					customerPendingOrders();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			break;
		case 19:
			vendorOrders();
			break;
		case 20:
				try {
					vendorPendingOrders();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			break;
		}
			
	} while(choice!=21);
}
	



	public static void customerOrders() {
		int CustomerId;
		System.out.println("Enter Customer Id");
		CustomerId = sc.nextInt();
		try {
			List<Orders> OrdersList = new OrdersDAO().customerOrders(CustomerId);
			for (Orders orders : OrdersList) {
				System.out.println(orders);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void vendorOrders() {
		int VendorId;
		System.out.println("Enter Vendor Id");
		VendorId = sc.nextInt();
		try {
			List<Orders> OrdersList = new OrdersDAO().vendorOrders(VendorId);
			for (Orders orders : OrdersList) {
				System.out.println(orders);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void customerPendingOrders() throws ClassNotFoundException, SQLException {
		int cid;
		System.out.println("Enter Customer ID   ");
		cid = sc.nextInt();
		Orders orders = new OrdersDAO().customerPendingOrders(cid);
		System.out.println(orders);
	}
	
	public static void vendorPendingOrders() throws ClassNotFoundException, SQLException {
		int vid;
		System.out.println("Enter Vendor ID   ");
		vid = sc.nextInt();
		Orders orders = new OrdersDAO().vendorPendingOrders(vid);
		System.out.println(orders);
	}
	
public static void searchRestaurant() throws ClassNotFoundException, SQLException {
	int rid;
	System.out.println("Enter Restaurant ID   ");
	rid = sc.nextInt();
	Restaurant restaurant = new RestaurantDAO().searchRestaurant(rid);
	System.out.println(restaurant);
}

public static void showRestaurant() {
	try {
		List<Restaurant> restaurantList = new RestaurantDAO().showRestaurant();
		for (Restaurant restaurant : restaurantList) {
			System.out.println(restaurant);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void addRestaurant() {
		
		Scanner sc = new Scanner(System.in);
		Restaurant res = new Restaurant();
		System.out.println("Enter Restaurant Name  ");
		res.setRestaurantName(sc.next());
		System.out.println("Enter City   ");
		res.setCity(sc.next());
		System.out.println("Enter Branch   ");
		res.setBranch(sc.next());
		System.out.println("Enter Email Id ");
		res.setEmail(sc.next());
		System.out.println("Enter Contact No   ");
		res.setContactNo(sc.next());
		RestaurantDAO dao = new RestaurantDAO();
		try {
			System.out.println(dao.addRestaurant(res));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public static void showMenu() {
	int RestaurantId;
	System.out.println("Enter Restaurant Id");
	RestaurantId = sc.nextInt();
	try {
		List<Menu> menuList = new MenuDAO().showMenu(RestaurantId);
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void searchMenu() throws ClassNotFoundException, SQLException {
	int mid;
	System.out.println("Enter Restaurant ID   ");
	mid = sc.nextInt();
	Menu menu = new MenuDAO().searchMenu(mid);
	System.out.println(menu);
}


public static void addMenu() {
	
	Scanner sc = new Scanner(System.in);
	Menu menu = new Menu();
	System.out.println("Enter Restaurant Id  ");
	menu.setRestaurantId(sc.nextInt());
	System.out.println("Enter Item Name  ");
	menu.setItemName(sc.next());
	System.out.println("Enter Menu Type   ");
	menu.setMenuType(sc.next());
	System.out.println("Enter Calories   ");
	menu.setCalories(sc.nextInt());
	System.out.println("Enter Price ");
	menu.setPrice(sc.nextInt());
	MenuDAO dao = new MenuDAO();
	try {
		System.out.println(dao.addMenu(menu));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void showCustomer() {
	try {
		List<Customer> CustomerList = new CustomerDAO().showCustomer();
		for (Customer cus : CustomerList) {
			System.out.println(cus);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void searchCustomer() throws ClassNotFoundException, SQLException {
	int cid;
	System.out.println("Enter Customer ID   ");
	cid = sc.nextInt();
	Customer c = new CustomerDAO().searchCustomer(cid);
	System.out.println(c);
}


public static void addCustomer() {
	
	Scanner sc = new Scanner(System.in);
	Customer cus = new Customer();
	System.out.println("Enter Customer Name  ");
	cus.setCustomerName(sc.next());
	System.out.println("Enter Customer City   ");
	cus.setCustomerCity(sc.next());
	System.out.println("Enter Customer State   ");
	cus.setCustomerState(sc.next());
	System.out.println("Enter Customer Email Id ");
	cus.setCustomerEmail(sc.next());
	System.out.println("Enter Customer Contact No   ");
	cus.setCustomerContactNo(sc.next());
	CustomerDAO dao = new CustomerDAO();
	try {
		System.out.println(dao.addCustomer(cus));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void showVendor() {
	try {
		List<Vendor> VendorList = new VendorDAO().showVendor();
		for (Vendor v : VendorList) {
			System.out.println(v);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void searchVendor() throws ClassNotFoundException, SQLException {
	int vid;
	System.out.println("Enter Vendor ID  ");
	vid = sc.nextInt();
	Vendor v = new VendorDAO().searchVendor(vid);
	System.out.println(v);
}

public static void addVendor() {
	
	Scanner sc = new Scanner(System.in);
	Vendor ven = new Vendor();
	System.out.println("Enter Vendor Name  ");
	ven.setVendorName(sc.next());
	System.out.println("Enter Vendor City   ");
	ven.setVendorCity(sc.next());
	System.out.println("Enter Vendor State   ");
	ven.setVendorState(sc.next());
	System.out.println("Enter Vendor Email Id ");
	ven.setVendorEmail(sc.next());
	System.out.println("Enter Vendor Contact No   ");
	ven.setVendorContactNo(sc.next());
	VendorDAO dao = new VendorDAO();
	try {
		System.out.println(dao.addVendor(ven));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void showWallet() {
	try {
		List<Wallet> WalletList = new WalletDAO().showWallet();
		for (Wallet w : WalletList) {
			System.out.println(w);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void searchWallet() throws ClassNotFoundException, SQLException {
	int wid;
	System.out.println("Enter Wallet ID  ");
	wid = sc.nextInt();
	Wallet w = new WalletDAO().searchWallet(wid);
	System.out.println(w);
}

public static void placeOrder() throws ClassNotFoundException, SQLException {
	Orders order = new Orders();
	System.out.println("Enter Customer Id   ");
	order.setCustomerId(sc.nextInt());
	System.out.println("Enter Vendor Id  ");
	order.setVendorId(sc.nextInt());
	System.out.println("Enter Wallet Id  ");
	order.setWalletId(sc.nextInt());
	System.out.println("Enter Menu Id  ");
	order.setMenuId(sc.nextInt());
	System.out.println("Enter Quantity Ordered  ");
	order.setQuantityOrdered(sc.nextInt());
	System.out.println("Enter Comments  ");
	order.setComments(sc.next());
	OrdersDAO dao = new OrdersDAO();
	System.out.println(dao.placeOrder(order));
}

public static void acceptOrReject() throws ClassNotFoundException, SQLException {
	int VendorId;
	int OrderId;
	String Status;
	System.out.println("Enter Vendor Id   ");
	VendorId = sc.nextInt();
	System.out.println("Enter Order Id   ");
	OrderId = sc.nextInt();
	System.out.println("Enter Status   ");
	Status =sc.next();
	System.out.println(new OrdersDAO().acceptOrRejectOrder(OrderId, VendorId, Status));
}

}

