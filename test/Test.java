package test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.Booksdao;
import dao.Customersdao;
import model.*;

import database.JDBCUtil;

public class Test {
	public static void main(String[] args) {
//		JDBCUtil util = new JDBCUtil();
//		Connection c = JDBCUtil.getConnection();
//	System.out.println(c);	
		//com.mysql.cj.jdbc.ConnectionImpl@2f7c2f4f
	
	//TEST :INSERT THÔNG QUA DAO 
	Books book1 = new Books (20,"Naruto",98.07f,"2008");
//    System.out.println(	Booksdao.getInstance().insert(book1));
////    TEST: VIẾT HÀM UPDATE
//	//update a book into book1 (what any book has similar id as book1) 
//    System.out.println(Booksdao.getInstance().update(book1));
//    
//    //TEST : VIẾT HÀM UPDATE, DELETE, SELECT 
//    Books book2 = new Books (17,"dr.stone",8.9f,"2019");
//    System.out.println(	Booksdao.getInstance().insert(book2));
	
	//TEST: VIẾT HÀM DELETE
	//System.out.println( Booksdao.getInstance().delete(book1));
    
	//TEST: VIẾT HÀM SELECT ALL
	System.out.println( Booksdao.getInstance().selectAll());
//	System.out.println( Booksdao.getInstance().selectByID(book1));
	System.out.println( Booksdao.getInstance().selectByCondition("ID > 15 AND PRICE < 15"));
    
    //CUSTOMER TEST:
    //TEST: VIẾT HÀM INSERT
	//	Customers cus1 = new Customers (16,"SONGOKU","SAIYAN","19981102"); 
		//Customers cus2 = new Customers (12,"CharlieII","HOKKAIDO","19991209"); 
		//Customers cus3 = new Customers (13,"CharlieIII","HANOI","20110315"); 
//	System.out.println(	Customersdao.getInstance().insert(cus1));
//	System.out.println(	Customersdao.getInstance().insert(cus2));
//	System.out.println(	Customersdao.getInstance().insert(cus3));
	
	//TEST: VIẾT HÀM UPDATE 
	//System.out.println( Customersdao.getInstance().update(cus1));
	
	//TEST: VIẾT HÀM DELETE 
//		System.out.println(	Customersdao.getInstance().delete(cus3));
	
	//TEST: VIẾT HÀM SELECT ALL
	//System.out.println( Customersdao.getInstance().selectAll() );
	
	//TEST: VIẾT HÀM SELECT BY ID 
//	System.out.println( Customersdao.getInstance().selectByID(cus1) );
	
	//TEST: VIẾT HÀM SELECT BY CONDITION 
//		String condition = "ID < 15 ";
//		System.out.println( Customersdao.getInstance().selectByCondition(condition));
    
	
	

  }

}
