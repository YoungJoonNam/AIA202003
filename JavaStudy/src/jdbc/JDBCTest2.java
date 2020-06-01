package jdbc;

import java.sql.*;

public class JDBCTest2 {

	public static void main(String[] args) throws ClassNotFoundException {
				
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			// 1. DB 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("데이터베이스에 접속했습니다.");
						
			// 3. Statement : Connection
			
			Statement stmt = conn.createStatement();
			
			//String sql = "select * from dept order by deptno";
			String sql = "select empno,ename,job from emp order by empno";
			String sql1 = "select o.orderid, c.name, b.bookid from customer c, book b, orders o "
					+ "where c.custid=o.custid and o.bookid=b.bookid";
			
			
			// Select 의 결과는 Resultset 이 받는다.
			// executeQuery (sql 문) -> ResultSet
			// rs = stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql1);
			
			// ResultSet : next() -> 행의 존재 유무 확인					
			
			
			while(rs.next()) {
//				System.out.print(rs.getInt("deptno")+"\t");
//				System.out.print(rs.getString("dname")+"\t");
//				System.out.print(rs.getString("loc")+"\n");				
//				
//				
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString(3)+"\n");
			}
			
			
			
			rs.close();
			stmt.close();
				
			// 4. close
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch (SQLException se) {
			
			System.out.println(se.getMessage());
		} 

		
	}
	

}

