package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest6 {

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
			//String sql = "insert into dept (deptno, dname, loc) values (?, ?, ?)";
			String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
//			pstmt.setInt(1, 70);
//			pstmt.setString(2, "마케팅");
//			pstmt.setString(3, "서울");
			
			pstmt.setInt(1, 55);
			pstmt.setString(2, "aa");
			pstmt.setString(3, "bb");
			pstmt.setInt(4, 10);
			pstmt.setString(5, "20200102");
			pstmt.setInt(6, 2000);
			pstmt.setInt(7, 100);
			pstmt.setInt(8, 10);
			
			int resultCnt = pstmt.executeUpdate();
			
			System.out.println("=============================");
			if(resultCnt > 0) {
				System.out.println("정상적으로 입력되었습니다."+resultCnt);
			} else {
				System.out.println("입력이 되지 않았습니다. 확인 후 재시도 해주세요."+resultCnt);
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




