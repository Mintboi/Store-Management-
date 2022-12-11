
//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------
import java.io.*;
//--------------------------------------------------
//
//	CLASS MyMain
//
//--------------------------------------------------
// This class contains all methods relevant to product management
public class product{
	private int id;
	private int qty;
	private String name;
	private String desc;
	private String type;
	private double value;

// Constructor
	product(int _id, String _name, String _desc, String _type, double _value, int _qty){
		this.id = _id;
		this.name = _name;
		this.desc = _desc;
		this.type = _type;
		this.value = _value;
		this.qty = _qty;
	}

	public String details(){return "Id: " + this.id + "\nName: " + this.name + "\nDescription: "
			+ this.desc + "\nType: " + this.type + "\nValue: " + this.value + "\nQty: " + this.qty;}

	public String data(){return this.id +","+ this.name +","+ this.desc +","+ this.type +","+ this.value +","+ this.qty;}

}
