//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.io.*;
//--------------------------------------------------
//
//	CLASS Customer
//
//--------------------------------------------------
//This class contains all methods used in relation to the user
public class Customer {
	private String custID;
	private String custFName;
	private String custSName;
	public Customer(String _custID, String _custFName, String _custSName)
	{
		this.custID = _custID;
		this.custFName = _custFName;
		this.custSName = _custSName;
	}
	//---------------------------------------
	//	data
	//---------------------------------------
	/**
	 * Creates a String of data for storing Customer information in a text file that can be used in a certain format
	 */
	public String data(){
		 return (this.custID +","+this.custFName+","+this.custSName);
	}

	//---------------------------------------
	//	GetFname
	//---------------------------------------
	/**
	 * This method returns the customers First name
	 * @return Customer Firstname
	 */
	public String GetFName(){
		return this.custFName;
	}


	//Getters and Setters
	public String getCustID() {
		return this.custID;
	}

	public void setCustID(String _custID) {
		this.custID = _custID;
	}

	public void setCustFName(String _custFName) {
		this.custFName = _custFName;
	}

	public String getCustSName() {
		return this.custSName;
	}

	public void setCustSName(String _custSName) {
		this.custSName = _custSName;
	}
}

