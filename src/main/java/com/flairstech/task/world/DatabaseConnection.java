package com.flairstech.task.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;
	private String url ;
	private String username ;
	private String password ;
	private String driver;

	private DatabaseConnection() throws Exception {
		try {

			File file = new File("db.conf");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
			{
				String values[] = st.split("=");
				if(values[0].equals("url")) {
					url = values[1] ;
				}
				if(values[0].equals("username")) {
					username = values[1] ;
				}
				if(values[0].equals("password")) {
					password = values[1] ;
				}
				if(values[0].equals("driver")) {
					driver = values[1] ;
				}
			}

			Class.forName(driver);
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			throw new Exception("INTERNAL_ERROR");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance() throws Exception {
		if (instance == null) {
			instance = new DatabaseConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DatabaseConnection();
		}

		return instance;
	}
}
