/*
This is the main class for my Java Project,
Author: Martin Swift
Student ID: R00212573
Date Created: 19/11/2022
*/

//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------
//
//	CLASS MyMain
//
//--------------------------------------------------
// This class implements all other classes in a user environment
public class MyMain{
	static potteryInterfaceImp pImp = new potteryInterfaceImp();
	static File custFile = new File("C:\\Users\\Swift\\Desktop\\Year 2\\OOP\\A03\\A03_Student_Java_Application\\/databases/customers.txt");
	static File orderFile = new File("C:\\Users\\Swift\\Desktop\\Year 2\\OOP\\A03\\A03_Student_Java_Application\\databases\\orders.txt");
	static File productFile = new File("C:/Users/Swift/Desktop/Year 2/OOP/A03/A03_Student_Java_Application/databases/products.txt");
	public static void userSelect(int _min, int _max, Scanner sc) {
		System.out.println("------------------------------------");
		System.out.println("	John O'Ryans Pottery			  	  ");
		System.out.println("------------------------------------");
		System.out.println("0. Exit");
		System.out.println("1. Create New User");
		System.out.println("2. Display User Info");
		System.out.println("3. Add Product");
		System.out.println("4. Create Order");
		System.out.println("5. View Orders");
		System.out.println("6. View Products");
		System.out.println("7. Remove Products");
		System.out.println("8. Remove Orders");
		System.out.println("9. Remove Customers");
		System.out.print(">> ");
		int selection = sc.nextInt();
		while(selection < _min || selection > _max){
			System.out.println("Please enter a valid selection:");
			System.out.print(">> ");
			selection = sc.nextInt();
		}
		sessionCase(selection, sc);
	}
	//---------------------------------------
	//	createCustomer
	//---------------------------------------
	/**
	 * Takes the user input to create a customer object and writes it to the given file
	 */
	public static void createCustomer(Scanner sc){
		ArrayList<String> products = new ArrayList<String>(10);;
		String createCustomer = "y";
		sc.nextLine();
		while(createCustomer.toUpperCase().equals("Y")){
			System.out.println("------------------------------------");
			System.out.println("  Create a new Customer Profile			  	  ");
			System.out.println("------------------------------------");
			System.out.println("Please enter the Customer ID:");
			System.out.print(">> ");
			String id = sc.nextLine();
			System.out.println("Please enter the customer's first name:");
			System.out.print(">> ");
			String fname = sc.nextLine();
			System.out.println("Please enter the customer's surname:");
			System.out.print(">> ");
			String sname = sc.nextLine();
			Customer customer = new Customer(id,fname,sname);
			pImp.Write(custFile, customer.data());

			System.out.println("Would you like to create another customer? (y/n)");
			System.out.print(">> ");
			createCustomer = sc.nextLine();
		}}
	//---------------------------------------
	//	createOrder
	//---------------------------------------
	/**
	 * Takes the user input to create order information, then searches for the Customer ID and product ID's until complete
	 * then writes the object to a file
	 */
	public static void createOrder(Scanner sc){
		ArrayList<Integer> products = new ArrayList<Integer>(10);;
		String createNewOrder = "y";
		while(createNewOrder.toUpperCase().equals("Y")){
			System.out.println("------------------------------------");
			System.out.println("	Create a new Order			  	  ");
			System.out.println("------------------------------------");
			System.out.println("Please enter the Customer ID:");
			System.out.print(">> ");
			String id = sc.nextLine();
			sc.nextLine();
			System.out.println("Please enter the payment type of the order, Cash or Card:");
			System.out.print(">> ");
			String paymentType = sc.nextLine();
			System.out.println("Please enter the type of Order, Delivery or collection:");
			System.out.print(">> ");
			String type = sc.nextLine();;
			System.out.println("Please enter the product id:");
			System.out.print(">> ");
			products.add(sc.nextInt());
			sc.nextLine();
			System.out.println("Would you like to enter another product id? (y/n)");
			System.out.print(">> ");
			String addProduct = sc.nextLine();
			while(addProduct.toUpperCase().equals("Y")){
				System.out.println("Please enter the product id:");
				System.out.print(">> ");
				products.add(sc.nextInt());
				sc.nextLine();
				System.out.println("Would you like to enter another product id? (y/n)");
				System.out.print(">> ");
				addProduct = sc.nextLine();
			}
			System.out.println("Order created successfully, would you like to create another? (y/n)");
			System.out.print(">> ");
			createNewOrder = sc.nextLine();
			Order Order1 = new Order(id,paymentType,type, products);
			pImp.Write(orderFile, Order1.data());
		}
	}
	//---------------------------------------
	//	createProduct
	//---------------------------------------
	/**
	 * Takes the user input and creates a product object for printing
	 */
	public static void createProduct(Scanner sc){
		String createNewProduct = "y";
		while(createNewProduct.toUpperCase().equals("Y")){
			System.out.println("------------------------------------");
			System.out.println("	Insert a new product			  	  ");
			System.out.println("------------------------------------");
			System.out.println("Please enter the ID of the product:");
			System.out.print(">> ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter the name of the product:");
			System.out.print(">> ");
			String name = sc.nextLine();
			System.out.println("Please enter the description of the product:");
			System.out.print(">> ");
			String desc = sc.nextLine();
			System.out.println("Please enter the type of product:");
			System.out.print(">> ");
			String type = sc.nextLine();;
			System.out.println("Please enter the value of the product:");
			System.out.print(">> ");
			double value = sc.nextDouble();
			sc.nextLine();
			System.out.println("Please enter the Quantity of products being added:");
			System.out.print(">> ");
			int qty = sc.nextInt();
			sc.nextLine();
			product Product1 = new product(id,name,desc,type,value, qty);
			pImp.Write(productFile, Product1.data());
			System.out.println("Product created successfully, would you like to create another? (y/n)");
			System.out.print(">> ");
			createNewProduct = sc.nextLine();
		}
		System.out.println("Thank you for choosing O'Ryans");
	}
	//---------------------------------------
	//	sessionCase
	//---------------------------------------
	/**
	 * Takes the user input and runs the selected function using a switch statement
	 */
	public static void sessionCase(int _option, Scanner sc){
		switch (_option) {
			case 0:
				System.out.println("Exiting");
				System.out.println("Thank you for choosing O'Ryans");
				System.exit(0);
				break;
			case 1:
				createCustomer(sc);
				System.out.println("Customer Created Successfully");
				break;
			case 2:
				System.out.println("1. Display User Info");
				pImp.Read(custFile);
				break;
			case 3:
				createProduct(sc);
				System.out.println("Product(s) Created Successfully");
				break;
			case 4:
				createOrder(sc);
				System.out.println("Order(s) Placed Successfully");
				break;
			case 5:
				System.out.println("5. View Orders");
				pImp.Read(orderFile);
				break;
			case 6:
				System.out.println("6. View Products");
				pImp.Read(productFile);
				break;
			case 7:
				System.out.println("7. Remove Product");
				System.out.println("Please insert the product Id you want to remove: ");
				System.out.print(">> ");
				sc.nextLine();
				String id = sc.nextLine();
				pImp.Remove(productFile, id);
				break;
			case 8:
				System.out.println("8. Remove Order");
				System.out.println("Please insert the Order Id you want to remove: ");
				System.out.print(">> ");
				sc.nextLine();
				String orderId = sc.nextLine();
				pImp.Remove(orderFile, orderId);
				break;
			case 9:
				System.out.println("9. Remove Customer");
				System.out.println("Please insert the Customer Id you want to remove: ");
				System.out.print(">> ");
				sc.nextLine();
				String custId = sc.nextLine();
				pImp.Remove(custFile, custId);
				break;
		}
	}

	//---------------------------------------
	//	useSession
	//---------------------------------------
	/**
	 * This method creates the Scanner used across the program and closes when finished
	 */
	public static void useSession(){
		Scanner sc = new Scanner(System.in);
		userSelect(0,10, sc);
		//sc.close();
	}

	//---------------------------------------
	//	Main
	//---------------------------------------
	/**
	 * This endlessly loops through the useSession function until the exit button is selected or an error is thrown
	 */
	public static void main(String[] args) {
		while(true){
			useSession();
		}
	}

}



