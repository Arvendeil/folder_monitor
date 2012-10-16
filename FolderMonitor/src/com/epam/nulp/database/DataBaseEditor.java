package com.epam.nulp.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.epam.nulp.info.Book;
import com.epam.nulp.parser.DOMParser;
import com.epam.nulp.parser.FileWorker;

public class DataBaseEditor {
    private static Properties pr = new Properties();

    public static void addBookInBD() {
	try {
	    pr.load(DataBaseEditor.class.getClassLoader().getResourceAsStream(
		    "data_en.properties"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	DataBaseConnector link = new DataBaseConnector();
	Connection connection;
	try {
	    connection = link.connection();
	    List<File> listOfFile = new ArrayList<File>();
	    listOfFile.addAll(FileWorker.getFullFileList(pr
		    .getProperty("folder")));
	    for (File file : listOfFile) {
		List<Book> listOfBooks = DOMParser.parse(file);
		Statement statement = connection.createStatement();
		for (Book book : listOfBooks) {
		    String request = "INSERT INTO Books VALUES ('"
			    + book.getAuthor() + "', '" + book.getTitle()
			    + "', '" + book.getGenre() + "', '"
			    + book.getPrice() + "', '" + book.getYear()
			    + "', '" + book.getPublication() + "','"
			    + book.getReview() + "')";
		    statement.executeUpdate(request);
		}
	    }
	    for (File file : listOfFile)
		file.delete();
	    link.closeConnection();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
