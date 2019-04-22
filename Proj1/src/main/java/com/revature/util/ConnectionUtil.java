package com.revature.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
//
public class ConnectionUtil {
	private static final String DB_DRIVER_CLASS="driver.class.name";
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	private static final String DB_URL ="db.url";
	
	private static Connection connection = null;
	private static Properties properties = null;
	
	public static Connection getConnection(ServletContext context){
		
			try {
				properties = new Properties();
				String fullPath = context.getRealPath("connection.properties");
				properties.load(new FileInputStream(fullPath));
				Class.forName(properties.getProperty(DB_DRIVER_CLASS));
				connection = DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USERNAME) , properties.getProperty(DB_PASSWORD) );
				System.out.println("connection");
				System.out.println(connection);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		
		
		return connection;
	}
}