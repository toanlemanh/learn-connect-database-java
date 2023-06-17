package dao;
import model.*;
import java.sql.*;
import java.util.ArrayList;

import database.JDBCUtil;

public class Customersdao implements Idao<Customers> {
	private static Customersdao instance = null;
	private Customersdao () {};
	
	public static Customersdao getInstance () {
		if ( instance == null )
			instance = new Customersdao();
		return instance;
	}
	
	
	@Override
	public int insert(Customers customer) {
		// TODO Auto-generated method stub
		int changedLines = 0;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "INSERT INTO CUSTOMERS (ID, CUSTOMER_NAME, ADDRESS, DOB)\r\n"
				    +" VALUES ("+ customer.getId()+ " , '"+ customer.getCustomer_Name()+"' , '"
				    + customer.getAddress()+"' , '"+ customer.getDob()+"')";
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			Statement stm = conn.createStatement();
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			changedLines = stm.executeUpdate(sql);
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}
		
		return changedLines;
	}

	@Override
	public int update(Customers customer) {
		// TODO Auto-generated method stub
		int changedLines = 0;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "UPDATE CUSTOMERS \r\n"
				  + "SET CUSTOMER_NAME = '"+ customer.getCustomer_Name()+"',"
				  + "ADDRESS = '"+ customer.getAddress()+"' ,DOB = '"+ customer.getDob()+"'\r\n"
				  + "WHERE ID = "+ customer.getId();
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			Statement stm = conn.createStatement();
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			changedLines = stm.executeUpdate(sql);
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}
		
		return changedLines;
		
	}

	@Override
	public int delete(Customers customer) {
		// TODO Auto-generated method stub
		int changedLines = 0;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "DELETE FROM CUSTOMERS \r\n"
				   + "WHERE ID = "+ customer.getId();
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			Statement stm = conn.createStatement();
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			changedLines = stm.executeUpdate(sql);
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}
		
		return changedLines;
	}

	@Override
	public ArrayList<Customers> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Customers> array = new ArrayList<>();
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
				Connection conn = JDBCUtil.getConnection();
				
				//BƯỚC 2: VIẾT CÂU LỆNH SQL
				String sql = "SELECT * FROM CUSTOMERS";
				
				try {
				//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
					Statement stm = conn.createStatement();
					System.out.println(sql);
					
				//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
					ResultSet reset = stm.executeQuery(sql);
					
				//BƯỚC 4.5: XỬ LÝ THÔNG TIN ĐẦU RA 
					// làm sao để lấy dữ liệu từ resultset
					
					while ( reset.next()) {
						int id = reset.getInt("ID");
						String name = reset.getString("CUSTOMER_NAME");
						String address = reset.getString("ADDRESS");
						String dob = reset.getString("DOB");
						Customers cus1 = new Customers(id, name, address, dob);
						array.add(cus1);
						
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
	public Customers selectByID(Customers customer) {
		// TODO Auto-generated method stub
		Customers cus1 = null;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "SELECT * FROM CUSTOMERS \n"
				+"WHERE ID = "+ customer.getId();
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			Statement stm = conn.createStatement();
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			ResultSet reset = stm.executeQuery(sql);
			
		//BƯỚC 4.5: XỬ LÝ THÔNG TIN ĐẦU RA 
			// làm sao để lấy dữ liệu từ resultset
			
			while ( reset.next()) {
				int id = reset.getInt("ID");
				String name = reset.getString("CUSTOMER_NAME");
				String address = reset.getString("ADDRESS");
				String dob = reset.getString("DOB");
				 cus1 = new Customers(id, name, address, dob);	
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}
		return cus1;
	}

	@Override
	public Customers selectByCondition(String condition) {
		// TODO Auto-generated method stub
		Customers cus1 = null;
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE 
		Connection conn = JDBCUtil.getConnection();
		
		//BƯỚC 2: VIẾT CÂU LỆNH SQL
		String sql = "SELECT * FROM CUSTOMERS \n"
				+"WHERE "+ condition;
		
		try {
		//BƯỚC 3: TẠO ĐỐI TƯỢNG STATEMENT	
			Statement stm = conn.createStatement();
			System.out.println(sql);
			
		//BƯỚC 4: VIẾT LOẠI HÀM SỬ DỤNG SQL THÍCH HỢP
			ResultSet reset = stm.executeQuery(sql);
			
		//BƯỚC 4.5: XỬ LÝ THÔNG TIN ĐẦU RA 
			// làm sao để lấy dữ liệu từ resultset
			
			while ( reset.next()) {
				int id = reset.getInt("ID");
				String name = reset.getString("CUSTOMER_NAME");
				String address = reset.getString("ADDRESS");
				String dob = reset.getString("DOB");
				 cus1 = new Customers(id, name, address, dob);	
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		//BƯỚC 5: NGẮT KẾT NỐI
		finally {
		    JDBCUtil.closeConnection(conn);
		}
		return cus1;
	}
	
}