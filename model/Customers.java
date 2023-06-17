package model;


public class Customers {
	private int id;
	private String customer_Name;
	private String address;
	private String dob;
	public Customers(int id, String customer_Name, String address, String dob) {
		super();
		this.id = id;
		this.customer_Name = customer_Name;
		this.address = address;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String toString () {
		return "_"+this.getId()+"_"+ this.getCustomer_Name()+"_"
	    + this.getAddress()+"_"+ this.getDob()+"_\n";
	}
	
	
	

}
