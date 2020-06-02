package phonebook202006;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoneBDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	PhoneBook	pb;
	
	PhoneBDAO() {		
		
	}
	
	
	void Init() {
		connection();
	}
	
	
	void connection() {
		try {		
			//데이터베이스 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			//System.out.println("Oracle 드라이버 로드 성공");
						
			//2. 데이터베이스 연결			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
					
			conn = DriverManager.getConnection(url, user, pw);
			//System.out.println("데이터베이스에 접속했습니다.");								
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.close();					
				} catch  (SQLException e1) {
					e1.printStackTrace();					
				}				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.close();					
				} catch  (SQLException e1) {
					e1.printStackTrace();					
				}				
			}
		} finally {			
				
		}
		
	}
	int input(PhoneBook pb) {
		
		int resultCnt=0;
		
		try {	
			//SQL 처리
			String sql = "insert into CONTACT (pidx,name,phoneNumber,address,email,type,major,grade,company,dept,rank,cafename,nickname) "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			
			//시퀀스번호를 가져와서 넣는다.
			//--pstmt.setInt(1, );			
			pstmt.setString(2, pb.getName());
			pstmt.setString(3, pb.getPhoneNumber());
			pstmt.setString(4, pb.getAddress());
			pstmt.setString(5, pb.getEmail());
			pstmt.setString(6, pb.getType());
			pstmt.setString(7, pb.getMajor());
			pstmt.setInt(8, pb.getGrade());
			pstmt.setString(9, pb.getCompany());
			pstmt.setString(10, pb.getDept());
			pstmt.setString(11, pb.getRank());
			pstmt.setString(12, pb.getCafename());
			pstmt.setString(13, pb.getNickname());
						
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			if(pstmt != null) {
				try {
					pstmt.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}		
		}
		
		return resultCnt;
		
	}
	
	int modify(PhoneBook pb) {
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "update CONTACT set name=?,phoneNumber=?,address=?,email=?,type=?,major=?,grade=?,company=?,dept=?,rank=?,cafename=?,nickname=? where pidx=?";
						
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, pb.getName());
			pstmt.setString(2, pb.getPhoneNumber());
			pstmt.setString(3, pb.getAddress());
			pstmt.setString(4, pb.getEmail());
			pstmt.setString(5, pb.getType());
			pstmt.setString(6, pb.getMajor());
			pstmt.setInt(7, pb.getGrade());
			pstmt.setString(8, pb.getCompany());
			pstmt.setString(9, pb.getDept());
			pstmt.setString(10, pb.getRank());
			pstmt.setString(11, pb.getCafename());
			pstmt.setString(12, pb.getNickname());
			pstmt.setString(13, pb.getPid() );
						
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			if(pstmt != null) {
				try {
					pstmt.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}		
		}
		
		return resultCnt;
		
	}
	
	int del(PhoneBook pb) {
		
		int resultCnt=0;
		
		try {
			String sql = "delete from CONTACT where pidx=?";
						
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, pb.getPid() );
									
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			if(pstmt != null) {
				try {
					pstmt.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}		
		}
		
		return resultCnt;		
	}
	
	ResultSet list() {
		try {
			stmt = conn.createStatement();
			
			String sql = "select pidx,name,phoneNumber,address,email,type,major,grade,company,dept,rank,cafename,nickname"
					+ " from CONTACT order by pidx";
	
			rs = stmt.executeQuery(sql);
			
//		
//			
//			
//			while(rs.next()) {
////				System.out.print(rs.getInt(1) + "\t");
////				System.out.print(rs.getString(2) + "\t");
////				System.out.print(rs.getString(3) + "\t");
////				System.out.print(rs.getInt(4) + "\t");
////				System.out.print(rs.getString(5) + "\t");
////				System.out.print(rs.getInt(6) + "\t");
////				System.out.print(rs.getInt(7) + "\t");								
////				System.out.print(rs.getInt(8) + "\n");
//				
//				System.out.printf("%-6d \t %12s \t %15s \t %10d \t %-10s \t\t %-10d \t %-10d \t %-4d %n",
//						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
//						rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
//			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			if(rs != null) {
				try {
					rs.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}
			if(stmt != null) {
				try {
					stmt.close();					
				} catch  (SQLException e) {
					e.printStackTrace();					
				}				
			}
		}
		
		return rs;
		
	}
	
	ResultSet search(PhoneBook pb) {
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename like ?";

			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			String enmaelike="%"+ename+"%";
			pstmt.setString(1, enmaelike);

			rs = pstmt.executeQuery();

//			while (rs.next()) {
//
//				System.out.printf("%-6d \t %12s \t %15s \t %10d \t %-10s \t\t %-10d \t %-10d \t %-4d %n", rs.getInt(1),
//						rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
//						rs.getInt(8));
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return rs;
		
	}
	
	void end() {
		
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
