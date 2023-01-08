package com.fiorin.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootTest
class ApplicationTests {
//	private static final String DB_URL = System.getenv("db_url");
//	private static final String DB_USER = System.getenv("db_user");
//	private static final String DB_PASSWORD = System.getenv("db_password");
//
//	private static Connection getConnection() throws SQLException, ClassNotFoundException {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Properties props = new Properties();
//		props.put("user", DB_USER);
//		props.put("password", DB_PASSWORD);
//		Connection conn = DriverManager.getConnection(DB_URL,props);
//		//conn.setAutoCommit(false);
//		return conn;
//	}

	@Test
	void contextLoads() {

	}
}
