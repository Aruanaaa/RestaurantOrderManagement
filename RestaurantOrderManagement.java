
class MenuItem {
	private String name;
	private double price;
	private String category;


	public MenuItem(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MenuItem{" +
		       "name='" + name + '\'' +
		       ", price=" + price +
		       ", category='" + category + '\'' +
		       '}';
	}
}


class Order {
	private int orderId;
	private String customerName;
	private MenuItem[] items;


	public Order(int orderId, String customerName, MenuItem[] items) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.items = items;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public MenuItem[] getItems() {
		return items;
	}

	public void setItems(MenuItem[] items) {
		this.items = items;
	}


	public double calculateTotal() {
		double total = 0;
		for (MenuItem item : items) {
			total += item.getPrice();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder itemsList = new StringBuilder();
		for (MenuItem item : items) {
			itemsList.append(item.toString()).append("\n");
		}
		return "Order{" +
		       "orderId=" + orderId +
		       ", customerName='" + customerName + '\'' +
		       ", items=\n" + itemsList.toString() +
		       ", total= " + calculateTotal() +
		       '}';
	}
}


class Restaurant {
	private String name;
	private String address;
	private MenuItem[] menu;


	public Restaurant(String name, String address, MenuItem[] menu) {
		this.name = name;
		this.address = address;
		this.menu = menu;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MenuItem[] getMenu() {
		return menu;
	}

	public void setMenu(MenuItem[] menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		StringBuilder menuList = new StringBuilder();
		for (MenuItem item : menu) {
			menuList.append(item.toString()).append("\n");
		}
		return "Restaurant{" +
		       "name='" + name + '\'' +
		       ", address='" + address + '\'' +
		       ", menu=\n" + menuList.toString() +
		       '}';
	}
}


public class RestaurantOrderManagement {
	public static void main(String[] args) {

		MenuItem item1 = new MenuItem("Burger", 5.99, "Main Course");
		MenuItem item2 = new MenuItem("Fries", 2.99, "Side");
		MenuItem item3 = new MenuItem("Coke", 1.99, "Drink");


		MenuItem[] menu = {item1, item2, item3};
		Restaurant restaurant = new Restaurant("Tasty Bites", "123 Main Street", menu);


		MenuItem[] orderItems1 = {item1, item3};
		Order order1 = new Order(1, "Alice", orderItems1);

		MenuItem[] orderItems2 = {item2, item3, item3};
		Order order2 = new Order(2, "Bob", orderItems2);


		System.out.println(restaurant);


		System.out.println(order1);
		System.out.println(order2);


		System.out.println("Are the orders equal? " + (order1.calculateTotal() == order2.calculateTotal()));
	}
}
