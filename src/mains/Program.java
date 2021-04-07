package mains;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName= keyboard.nextLine();
        System.out.print("Email: ");
        String clientEmail= keyboard.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate =sdf.parse(keyboard.next()) ;
        Client client = new Client(clientName,clientEmail, birthDate);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String clientStatus = keyboard.next();
        Date date = new Date();
        Order order = new Order(date,OrderStatus.valueOf(clientStatus));
        System.out.print("How many items to this order? ");
        int n = keyboard.nextInt();

        for(int i =1; i <= n;i++){
            System.out.println("Enter #"+i+ " item data: ");
            System.out.print("Product name: ");
            String itemName = keyboard.next();
            System.out.print("Product price: ");
            double priceItem = keyboard.nextDouble();
            System.out.print("Quantity: ");
            int quantityItem = keyboard.nextInt();
            OrderItem orderItem = new OrderItem(quantityItem,priceItem,new Product(itemName));
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: "+ sdf1.format(date));
        System.out.println("Order status: "+order.getStatus());
        System.out.println("Client: "+ client);
        System.out.println("ORDER ITEMS:");
        for (OrderItem item : order.getItems()){
            System.out.println(item);
        }
        System.out.print("Total price: $"+ order.total());
        System.out.println();





    }
}
