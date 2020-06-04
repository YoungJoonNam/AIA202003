package jdbc;

import java.sql.*;

public class JDBCTest1 {

	public static void main(String[] args) throws ClassNotFoundException {
				
		Connection conn = null;
		
		try {
			// 1. DB 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			//String url = "jdbc:oracle:thin:@localhost:1529:orcl"; 
				//The Network Adapter could not establish the connection
			//String url = "jdbc:oracle:thin:@210.1.2.5:1521:orcl";
				//The Network Adapter could not establish the connection
			//String url = "jdbc:oracle:thin:@localhost:1521:orcls";
				//Listener refused the connection with the following error:
				//ORA-12505, TNS:listener does not currently know of SID given in connect descriptor
			String user = "scott";
			//String user = "scott11"; 
				//ORA-01017: invalid username/password; logon denied
			String pw = "tiger";
			//String pw = "tiger11";
				//ORA-01017: invalid username/password; logon denied
			
			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("데이터베이스에 접속했습니다.");
			
			// 트랜잭션 설정
			conn.setAutoCommit(false);
			
			
			// 3. sql 로 데이터 처리
			
			
			
			conn.commit();
			// 4. close
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(se.getMessage());
		} 

		
	}
	

}

