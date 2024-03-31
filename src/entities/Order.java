package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order() {}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removetem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName());
		sb.append(" (" + sdf1.format(client.getBirthDate()) + ") " + "- " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		
		for (OrderItem item : items) {
			sb.append(item.getProduct().getName() + ", $");
			sb.append(String.format("%.2f", item.getPrice()) + ", ");
			sb.append("Quantity: " + item.getQuantity() + ", ");
			sb.append("Subtotal: " + String.format("%.2f", item.subTotal()) + "\n");
		}
		
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
	
}
