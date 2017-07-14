package lm_xml_parser_test;

import java.util.ArrayList;

public class Demo_test {

	public static void main(String[] args) {
		XmlDomParser domParser = new XmlDomParser();
		domParser.xmlDomParse("books.xml");
		
		ArrayList<Book> books = domParser.getBooklist();
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
