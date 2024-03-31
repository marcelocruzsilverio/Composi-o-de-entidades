package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String dateInput = sc.nextLine();
		Date date = sdf.parse(dateInput);
		
		Client client = new Client(clientName, clientEmail, date);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String statusOrder = sc.next();
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Date dateOrder = new Date();
		Date moment = sdf1.parse(sdf1.format(dateOrder));
		
		Order order = new Order(moment, OrderStatus.valueOf(statusOrder), client);
		OrderItem item = new OrderItem();
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			item = new OrderItem(productQuantity, productPrice, product);	
			order.addItem(item);
		}
		
		
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		
		System.out.print(order);
		
		sc.close();

	}

}
