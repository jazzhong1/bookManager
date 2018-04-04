package com.mvc.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnect {

	public DBConnect() {

	}

	public static Connection getConnect() {
		Connection conn = null;

		try {
			Properties prop = new Properties();
			prop.load(new BufferedReader(new FileReader("resource/driver.properties")));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pw"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void disConnect(ResultSet rs, PreparedStatement psmt, Connection conn) {
		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void disConnect(PreparedStatement psmt, Connection conn) {
		try {
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
