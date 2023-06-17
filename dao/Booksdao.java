package dao;

import model.*;

import java.util.ArrayList;
import java.sql.*;
import database.JDBCUtil;

//overview: Booksdao là nơi chứa các method hỗ trợ cho model Books quản lý đối tượng và dữ liệu
// thông qua các thao tác phổ biến như CRUD 

public class Booksdao implements Idao<Books> {
	
	//Booksdao chỉ cần một instance duy nhất 
	// tránh gọi quá nhiều Booksdao một lúc 
	private static Booksdao instance =  null;
	public static Booksdao getInstance () {
		if (instance == null) 
			instance = new Booksdao();
		return instance;
	}
	private Booksdao () {};

	@Override
	public int insert(Books book) {
		// TODO Auto-generated method stub
		int changedLines = 0;
		//BƯỚC1: TẠO KẾT NỐI ĐẾN DATABASE
	    // KHI VIẾT HÀM getConnection () đã xử lý exception
	    Connection c = JDBCUtil.getConnection();
	    
	    //BƯỚC2: VIẾT CÂU LỆNH SQL \"TUAN\"
		
		String sql = "INSERT INTO BOOKS (ID, BOOK_NAME, PRICE, MFG) \n"
		            +"VALUES (?,?,?,?)"; 
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG PREPAREDSTATEMENT
			
		PreparedStatement pst = c.prepareStatement(sql);
		 pst.setInt(1,book.getId());//1
		 pst.setString(2,book.getBook_name());//
		 pst.setFloat(3,book.getPrice());//3.56f
		 pst.setString(4,book.getMfg());//
//		 Statement stm = c.createStatement();
		
		//BƯỚC 4: SỬ DỤNG HÀM PHÙ HỢP VỚI MỤC ĐÍCH CÂU TRUY VẤN SQL
		 changedLines = pst.executeUpdate();
		 
		 // There are 3 methods to execute SQL statements like
		 // => whenever working with sql libraries and utils => wrapping your own method 
		 //by try-catch block 
		 
		 // execute (String sql) : Boolean
		 // executeQuery (String sql) : ResultSet 
		 // executeUpdate (String sql : Integer 		 
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
        //BƯỚC 5: NGẮT KẾT NỐI
		 JDBCUtil.closeConnection(c);
		}
		return changedLines;
	}

	
	//update what book has similar id 
	@Override
	public int update(Books book) {
		// TODO Auto-generated method stub
		int changedLines = 0;
		int id = 13;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection c = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "UPDATE BOOKS\r\n"
				+ "SET BOOK_NAME = ?,"
				+ "PRICE = ?," + " MFG = ?,"
				+ "WHERE ID = ?";
		
		//BƯỚC 3: TẠO STATEMENT OBJECT
		try {
//		Statement stm = c.createStatement();
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, book.getBook_name());
		pst.setFloat(2, book.getPrice());
		pst.setString(3, book.getMfg());
		pst.setInt(4, book.getId());
		//BƯỚC 4: VIẾT HÀM SỬ DỤNG SQL PHÙ HỢP
		changedLines = pst.executeUpdate();
		
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
			JDBCUtil.closeConnection(c);
		}
		
		return changedLines;
	}

	@Override
	public int delete(Books book) {
		// TODO Auto-generated method stub
		
		int changedLines = 0 ;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE
		Connection c = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "DELETE FROM books\r\n"
				+ "WHERE ID = ?"; // ? chỉ được dùng trong PreparedStatement
		
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT
		try {
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, book.getId());
		//BƯỚC 4: VIẾT HÀM SỬ DỤNG SQL TƯƠNG ỨNG 	
			changedLines = pst.executeUpdate ();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
		//BƯỚC 5: NGẮT KẾT NỐI
			JDBCUtil.closeConnection(c);
			
		}
		return changedLines;
	}

	@Override
	public ArrayList<Books> selectAll() {
		// TODO Auto-generated method stub 
		ArrayList<Books> array = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "SELECT * FROM books";
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			PreparedStatement pst = conn.prepareStatement(sql);
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			ResultSet reset = pst.executeQuery();
			
		//BƯỚC 4.5: XỬ LÝ THÔNG TIN ĐẦU RA 
			// làm sao để lấy dữ liệu từ resultset
			
			while ( reset.next()) {
				int id = reset.getInt("ID");
				String name = reset.getString("BOOK_NAME");
				Float price = reset.getFloat("PRICE");
				String mfg = reset.getString("MFG");
				Books book1 = new Books(id, name, price, mfg);
				array.add(book1);
				
			}
			// làm sao để add sang ArrayList kiểu Customers
			
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}

		return array;
	}

	@Override
	public Books selectByID(Books book) {
		// TODO Auto-generated method stub
		Books book1 = null;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: TẠO CÂU LỆNH SQL 
		String sql = "SELECT * FROM BOOKS \n"
				   + "WHERE ID = ?";
		
		//BƯỚC 3: TẠO ĐỐI TƯỢNG PREPARED STATEMENT
		try {
		    PreparedStatement pst = conn.prepareStatement(sql);
		    pst.setInt( 1, book.getId() );// At first question sign, set the value to 
		    // the id of the book 
		    
		//BƯỚC 4: VIẾT HÀM SỬ DỤNG MỤC ĐÍCH (TRẢ VỀ SỐ DÒNG, TRUE-FALSE, IN RA ?)
		    //execute the SQL command, and returning to ResultSet back
		    //this object holds the entire result of sql
		    //when using next(), it points subsequently each row. If has row, return true
		    //
		    ResultSet reset = pst.executeQuery();
		    while ( reset.next()) {
		    	int id = reset.getInt("ID");
		    	String name = reset.getString("BOOK_NAME");
		    	Float price = reset.getFloat("PRICE");
				String mfg = reset.getString("MFG");
				 book1 = new Books(id, name, price, mfg);
		    }
		}
		catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}
		finally {
//			BƯỚC 5: NGẮT KẾT NỐI 
			JDBCUtil.closeConnection(conn);
		}
	
		return book1;
	}
		
	
	
     public Books selectByCondition (String condition) {
    	  Books book1 =  null;
    	  
    	  //CREATE A CONNECTION
    	  Connection conn = JDBCUtil.getConnection();
    	  
    	  //CREATE A SQL 
    	  String sql = "SELECT * FROM BOOKS\n"
    			     + "WHERE "+ condition;
    	  
    	  //CREATE A STATEMENT OBJECT
    	  try {
    	  Statement st = conn.createStatement();
    	  
    	  //CHOOSE A STATEMENT METHOD 
    	  //=> PRINT 
    	  ResultSet reset = st.executeQuery (sql);
    	  
    	  while ( reset.next() ) {
    		  int id = reset.getInt("ID");
			   String name = reset.getString("BOOK_NAME");
			   float price = reset.getFloat("PRICE");
			   String mfg = reset.getString("MFG");
			   book1 = new Books(id,name,price,mfg);
    	     }
    	  }
    	  catch (SQLException sqle) {
    		  sqle.printStackTrace();
    	  }
    	  finally {
    	       JDBCUtil.closeConnection(conn);
    	  }
    	  return book1;
      }
     }

