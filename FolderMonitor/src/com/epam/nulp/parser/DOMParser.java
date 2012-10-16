package com.epam.nulp.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.nulp.info.Book;

public class DOMParser {

    public static List<Book> parse(File file) {
	List<Book> listOfBooks = new ArrayList<Book>();
	try {
	    DocumentBuilderFactory factory = DocumentBuilderFactory
		    .newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(file);
	    NodeList list = document.getElementsByTagName("book");
	    for (int i = 0; i < list.getLength(); i++) {
		Node node = list.item(i);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
		    Book book = new Book();
		    Element element = (Element) node;
		    book.setAuthor(getTagValue("author", element));
		    book.setTitle(getTagValue("title", element));
		    book.setGenre(getTagValue("genre", element));
		    book.setPrice(Float
			    .parseFloat(getTagValue("price", element)));
		    book.setYear(Integer.parseInt(getTagValue("year", element)));
		    book.setPublication(Long.parseLong(getTagValue(
			    "publication", element)));
		    book.setReview(getTagValue("review", element));
		    listOfBooks.add(book);
		}
	    }
	} catch (ParserConfigurationException e) {
	    e.printStackTrace();
	} catch (SAXException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return listOfBooks;
    }

    private static String getTagValue(String sTag, Element eElement) {
	NodeList nList = eElement.getElementsByTagName(sTag).item(0)
		.getChildNodes();
	Node value = (Node) nList.item(0);
	return value.getNodeValue();
    }

}
