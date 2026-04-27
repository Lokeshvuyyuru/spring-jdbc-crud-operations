package com.vuyu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) throws Exception{
		// Start IoC container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("jdbc.xml");

        ItemDAO dao = (ItemDAO) context.getBean("items");

        Scanner scan = new Scanner(System.in);

        int iid = 0;
        String iname = null;
        float iprice = 0.0f;

        while (true) {

            System.out.println("Following are the options:");
            System.out.println("--------------------------");
            System.out.println("1. Insert Item");
            System.out.println("2. Display Items");
            System.out.println("3. Modify Item Price");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {

                // INSERT
                case 1:
                    System.out.print("Enter Item ID: ");
                    iid = scan.nextInt();

                    System.out.print("Enter Item Name: ");
                    iname = scan.next();

                    System.out.print("Enter Item Price: ");
                    iprice = scan.nextFloat();

                    System.out.println("Inserting record... Please wait...");
                    dao.insertItem(iid, iname, iprice);

                    System.out.println("Record inserted successfully\n");
                    break;

                // DISPLAY
                case 2:
                    List<Map<String, Object>> itemsList = dao.displayItems();

                    System.out.println("Fetching items information... Please wait...");
                    Thread.sleep(2000);

                    System.out.println("ItemId\tItemName\tItemPrice");
                    System.out.println("-----------------------------------");

                    for (Map<String, Object> item : itemsList) {
                        System.out.println(
                                item.get("iid") + "\t" +
                                item.get("iname") + "\t\t" +
                                item.get("iprice")
                        );
                    }
                    System.out.println();
                    break;

                // UPDATE
                case 3:
                    System.out.print("Enter Item ID: ");
                    iid = scan.nextInt();

                    System.out.print("Enter new price: ");
                    iprice = scan.nextFloat();

                    System.out.println("Updating item price... Please wait...");
                    Thread.sleep(2000);

                    dao.updateItem(iid, iprice);

                    System.out.println("Item price updated successfully\n");
                    break;

                // DELETE
                case 4:
                    System.out.print("Enter Item ID: ");
                    iid = scan.nextInt();

                    System.out.println("Deleting item... Please wait...");
                    Thread.sleep(2000);

                    dao.deleteItem(iid);

                    System.out.println("Item deleted successfully\n");
                    break;

                // EXIT
                case 5:
                    System.out.println("Closing application... Please wait...");
                    Thread.sleep(1000);

                    System.out.println("Thanks for using our application! Visit again.");
                    System.exit(0);
                    break;

                // INVALID
                default:
                    System.out.println("Invalid choice, try again.\n");
            }
        }
    
	}

}
