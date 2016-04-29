package com.mycompany.app.hiveclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hive JDBC Client 
 *
 */
public class HiveJdbcClient {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(
				"jdbc:hive2://yourdomain.azurehdinsight.net:443/default;ssl=true?hive.server2.transport.mode=http;hive.server2.thrift.http.path=/hive2",
				"replace-with-username", "replace-with-password");
		Statement stmt = con.createStatement();
		String sql = "describe test";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2));
		}
	}
}
