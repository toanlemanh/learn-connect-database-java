package model;

public class Books {
//	ID INT NOT NULL AUTO_INCREMENT,
//	   BOOK_NAME VARCHAR(20) NOT NULL,
//	   PRICE MONEY  ,
//	   MFG YEAR ,
//	   PRIMARY KEY (ID)
//	)
//
//	CREATE TABLE CUSTOMERS (
//	   ID INT NOT NULL AUTO_INCREMENT,
//	   CUSTOMER_NAME VARCHAR(25) ,
//	   ADDRESS VARCHAR (10) ,
//	   DOB DATE ,
	private int id;
	private String book_name;
	private float price;
	private String mfg;
	
	public Books(int id, String book_name, float price, String mfg) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.price = price;
		this.mfg = mfg;
	}

	public Books(int id, String book_name) {
		super();
		this.id = id;
		this.book_name = book_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	public String toString () {
		return "_"+this.getId()+"_"+getBook_name()+"_"
				+ getPrice()+"_"+getMfg()+"\n";
	}
	
	
	
   
	
	

}
