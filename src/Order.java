import java.io.*;
import java.util.ArrayList;
import java.util.List;
import  java.util.Random;
public class Order {

	private final String custId;
	private final String paymentType;
	private final  Customer cust;
	private final ArrayList<Integer> productIds;
	private final ArrayList<String> products;
	private final String orderId;
	private final String type;

	public final File customersFile = new File("C:/Users/Swift/Desktop/Year 2/OOP/A03/A03_Student_Java_Application/databases/customers.txt");
	public final File productFile = new File("C:/Users/Swift/Desktop/Year 2/OOP/A03/A03_Student_Java_Application/databases/products.txt");
	Order(String _CustId,String _paymentType,String _type,ArrayList<Integer> _productIds){
		this.orderId = randomId(100000, 0);
		this.custId = _CustId;
		this.productIds = _productIds;
		this.paymentType = _paymentType;
		this.type = _type;
		this.products = findId() ;
		this.cust = findId(custId);
	}

	public String data(){return this.orderId +","+ this.custId+","+ this.cust.GetFName() +","+this.paymentType+","+this.products+","+this.type;}
	//---------------------------------------
	//	checkID
	//---------------------------------------
	/**
	 * This method returns a list of product names, filtering through the product file until all Ids have been found
	 * @return a list of product names for the order class
	 */
	private ArrayList<String> findId() {
		ArrayList<String> productList = new ArrayList<>(10);
		try {
			BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(productFile)));
				String id = " ";
			for (int i = 0; i < productIds.size(); i++) {
				while (true) {
					id = BR.readLine();
					System.out.println(id);
					if ((String.valueOf(productIds).contains(id.split(",")[0]))) {
						System.out.println("Product Found");
							String name = id.split(",")[1];
							productList.add(name);
							break;
					}
				}
			}
			BR.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return productList;
	}
	//---------------------------------------
	//	checkID
	//---------------------------------------
	/**
	 * This method searches the customer database and returns their name as a string using their ID and a search
	 * @return The customer name
	 */
	private Customer findId(String _custId) {
		try {
			BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(customersFile)));
			String id = " ";
			while (true) {
				id = BR.readLine();
				if (((id.contains(_custId)))) {
					System.out.println("Customer Found");
					String fname = id.split(",")[1];
					String sname = id.split(",")[2];
					Customer Customer1 = new Customer(this.custId, fname, sname);
					BR.close();
					return Customer1;
					}
				}

			} catch (Exception e) {System.out.println(e.getMessage());}

	return null;
	}
	//---------------------------------------
	//	randomId
	//---------------------------------------
	/**
	 * This method generates a random Id, then checks if it is already in the text file if it is it will generate another random number.
	 * @return An original ID for the order
	 */
	private String randomId(int max, int min){
		File file = new File("C:\\Users\\Swift\\Desktop\\Year 2\\OOP\\A03\\A03_Student_Java_Application\\databases\\orders.txt");

		// Create a list to store the numbers in the file
		List<String> numbersInFile = new ArrayList<>();
try{
		// Open the file for reading
		BufferedReader reader = new BufferedReader(new FileReader(file));

		// Read each line from the file
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {
			// Parse the number from the line and add it to the list
			numbersInFile.add(currentLine.split(",")[0]);
		}

		// Close the reader
		reader.close();
	}catch(Exception e){System.out.println("Sorry " + e);}
		// Generate a random number until we find one that is not in the file
		Random random = new Random();
		int randomNumber;
		do {
			randomNumber = random.nextInt((max - min) + 1) + min;
		} while (numbersInFile.contains(String.valueOf(randomNumber)));

		// Return the unique random number
	return String.valueOf(randomNumber);

	}
}

