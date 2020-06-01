package task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사원관리 프로그램
//   #기능
//		입력, 
//		수정(사원번호로 입력 - 이름,부서,급여), 
//		삭제(사원번호 기준), 
//		리스트,
//		검색(이름)

//2. 부서관리 프로그램
//#기능
//	입력, 
//	수정(부서번호로 입력 - 부서이름,위치), 
//	삭제(부서번호 기준), 
//	리스트,
//	검색(부서이름 or 지역)

public class JdbcManager implements DefineIF {
	

	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	void Init() {
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
	
	
	int inputEmp(int empno, String ename,String job,int mgr,String hiredate,int sal,int comm,int deptno) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?, ?, ?, ?, ?, ?, ?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);
						
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
	
	int modifyEmp(int empno, String ename,String job,int mgr,String hiredate,int sal,int comm,int deptno) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "update emp set empno=?,ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);
			pstmt.setInt(9, empno);
						
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
	
	int delEmp(int empno) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "delete from emp where empno=?";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			pstmt.setInt(1, empno);
									
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
	
	void listEmp() {
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp order by empno";
	
			rs = stmt.executeQuery(sql);
			
		
			
			while(rs.next()) {
//				System.out.print(rs.getInt(1) + "\t");
//				System.out.print(rs.getString(2) + "\t");
//				System.out.print(rs.getString(3) + "\t");
//				System.out.print(rs.getInt(4) + "\t");
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getInt(6) + "\t");
//				System.out.print(rs.getInt(7) + "\t");								
//				System.out.print(rs.getInt(8) + "\n");
				
				System.out.printf("%-6d \t %12s \t %15s \t %10d \t %-10s \t\t %-10d \t %-10d \t %-4d %n",
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
			}
			
			
		
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
		
	}
	
	void searchEmp(String ename) {
		
		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename like ?";

			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			String enmaelike="%"+ename+"%";
			pstmt.setString(1, enmaelike);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.printf("%-6d \t %12s \t %15s \t %10d \t %-10s \t\t %-10d \t %-10d \t %-4d %n", rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8));
			}

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
		
	}
	
	int inputDept(int deptno, String dname,String loc) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "insert into dept (deptno,dname,loc) values(?, ?, ?)";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
									
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
	
	int modifyDept(int deptno, String dname,String loc) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "update dept set dname=?,loc=? where deptno=?";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);			
			pstmt.setInt(3, deptno);
						
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
	
	int delDept(int deptno) {
		
		int resultCnt=0;
		
		try {	
			//3. SQL 처리
			String sql = "delete from dept where deptno=?";
						
			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			pstmt.setInt(1, deptno);
									
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
	
	void listDept() {
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select deptno,dname,loc from dept order by deptno";
	
			rs = stmt.executeQuery(sql);
			
		
			
			while(rs.next()) {
				
				System.out.printf("%-6d \t %12s \t %15s %n",
						rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
			
		
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
		
	}
	
	void searchDept(String dname) {
		
		try {
			String sql = "select deptno,dname,loc from dept where dname like ?";

			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			String enmaelike="%"+dname+"%";
			pstmt.setString(1, enmaelike);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.printf("%-6d \t %12s \t %15s%n",	rs.getInt(1),rs.getString(2), rs.getString(3));
			}
			
			sql = "select deptno,dname,loc from dept where loc like ?";

			pstmt = conn.prepareStatement(sql);
			// 변수 데이터 설정
			
			pstmt.setString(1, enmaelike);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.printf("%-6d \t %12s \t %15s%n",	rs.getInt(1),rs.getString(2), rs.getString(3));
			}
			

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

