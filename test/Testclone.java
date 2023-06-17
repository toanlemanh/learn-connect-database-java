package test;
import database.JDBCclone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testclone {
	public static void main(String[] args) {
		JDBCclone cl = new JDBCclone ();
		
		
		//BƯỚC 1: TẠO KẾT NỐI VỚI DATABASE THÔNG QUA JDBC DRIVER 
		// GỌI CONNECTION, KHỞI TẠO JDBC DRIVER 
		// COM.MYSQL.CJ.JDBC.DRIVER DRIVER = NEW COM.MYSQL.CJ.JDBC.DRIVER ()
		// TẠO KẾT NỐI THOONG QUA URL
		//String URL ="jdbc:mySQL://<server>:<port>/<database>"
		//dùng phươngthuwcs static getConnection( String url) của 
		//DriverManager để lấy kết nối  
		
		Connection c = cl.createConnection();
		System.out.println(c);
		
		//BƯỚC 2: CÂU LỆNH MUỐN TRUY VẤN TRONG SQL => MỤC ĐÍCH 
		// MUỐN INSERT VÀO BẢNG => DATA MANIPULATION LANGUAGE (DML STATEMENT)
		String sql = "INSERT INTO THONG_TIN_NGUOI_MUA ( HO , TEN , GIOI_TINH, THANH_TIEN )\r\n"
				+ "VALUES ('DAO',\"TUAN\",1,\"138$\"), (\"THI\",\"LUONG\",0,\"45$\")";
	    
		
		String sql1 = "DELETE from thong_tin_nguoi_mua\r\n"
		+ "WHERE TEN = \"TRUNG\" ";
		
		String sql2 = "SELECT * FROM THONG_TIN_NGUOI_MUA";
		try {
		//BƯỚC 3: KHỞI TẠO STATEMENT OBJECT TƯƠNG ỨNG từ CONNECTION OBJECT
	
		//CÓ 3 LOẠI STATEMENT:
		// + STATEMENT 
		// + PREPAREDSTATEMENT
		// + CALLABLESTATEMENT
			Statement stm = c.createStatement();
		
		//BƯỚC 4: GỌI PHƯƠNG THỨC PHÙ HỢP VỚI MỤC ĐÍCH CỦA CÂU TRUY VẤN
			int changedLines = stm.executeUpdate(sql); 
			// executeUpdate(String sql):int -> trả về số dòng trong table bị thay đổi
//			boolean check = stm.execute(sql1);
			ResultSet res = stm.executeQuery(sql2);
			
		//BƯỚC 5: XỬ LÝ DỮ LIỆU 
		//System.out.println(c);	
//			if ( check == true )
//				System.out.println("Update successfully");
//			else 
//				System.out.println("Update fails");
			
			
			// next() là hàm riêng của đối tượng ResultSet => nếu còn token thì true
//Moves the cursor forward one row from its current position.A ResultSet cursor is 
//initially positionedbefore the first row; the first call to the method next makes 
//the first row the current row; thesecond call makes the second row the current row, and so on. 
//When a call to the next method returns false,the cursor is positioned after the last row.

			while (res.next()) {
				//get() => lấy dữ liệu tương ứng với tên column label 
				// của row (đối tượng) hiện tại (row mà con trỏ đang đặt vào )
				System.out.println( res.getString("HO")+"-"+ res.getString("TEN")
				+"-"+ res.getBoolean("GIOI_TINH")+"-"+ res.getString("THANH_TIEN"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("You've tried to SELECT ALL FROM table");
		}
		
	
		//BƯỚC 6: NGẮT KẾT NỐI ĐẾN DATABASE 
		cl.closeConnection(c);
		
		

	}

}
