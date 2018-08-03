package it.molis.baionetta.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class DBConnect {

	private static String jdbcURL = "jdbc:mysql://localhost/baionetta?tcpKeepAlive=true&autoReconnect=true";

	private static DataSource ds;

	public static Connection getConnection() {

		if (ds == null) {
			try {
				ds = DataSources.pooledDataSource(DataSources.unpooledDataSource(jdbcURL, "fabio", "gtik9328"));
			} catch (SQLException e) {
				ds = null;
				//e.printStackTrace();
			}
		}
		try {
			Connection c = ds.getConnection();
			return c;
		} catch (SQLException e) {
			ds = null;
			//e.printStackTrace();
			return null;
		}
	}
}