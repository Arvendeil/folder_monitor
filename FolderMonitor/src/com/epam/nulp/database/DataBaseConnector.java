package com.epam.nulp.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnector {
    private Connection connection = null;
    private Properties pr = new Properties();

    public Connection connection() {
	try {
	    pr.load(DataBaseConnector.class.getClassLoader()
		    .getResourceAsStream("data_en.properties"));
	    Class.forName(pr.getProperty("driver"));
	    connection = DriverManager.getConnection(
		    pr.getProperty("url") + pr.getProperty("dbName"),
		    pr.getProperty("userName"), pr.getProperty("password"));
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	return connection;
    }

    public void closeConnection() {
	try {
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
