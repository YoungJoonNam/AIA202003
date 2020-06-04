package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest5 {

	public static void main(String[] args){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			//1. 데이터 베이스 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Oracle 드라이버 로드 성공");
			
			
			//2. 데이터베이스 연결
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
					
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			
			//3. SQL 처리
			// statement or preparedStatement
			//String sql = "select * from dept where deptno=?";
			String sql = "select * from dept where dname like ?";
			
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			//pstmt.setInt(1, 30);
			pstmt.setString(1, "%A%");
			
			rs = pstmt.executeQuery();
			
			System.out.println("부서 리스트");
			System.out.println("=============================");
			// ResultSet -> 결과 참조
			while(rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");				
			}
			System.out.println("=============================");
						

			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			//4. 데이터 베이스 연결 종료
			
			if(rs != null) {
				try {
					rs.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}
			if(pstmt != null) {
				try {
					pstmt.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}
			if(conn != null) {
				try {
					conn.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}			
		}
		
		
		
	}

}




