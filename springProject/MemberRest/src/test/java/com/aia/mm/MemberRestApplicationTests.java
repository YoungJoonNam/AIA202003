package com.aia.mm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRestApplicationTests {

	
	private DataSource dataSource;
			
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println(dataSource);
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
		
	}

}
