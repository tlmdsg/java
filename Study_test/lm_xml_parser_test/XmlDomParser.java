package lm_xml_parser_test;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDomParser {

	Book book = null;
	ArrayList<Book> booklist = new ArrayList<>();

	public void xmlDomParse(String file) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList books = document.getElementsByTagName("book");
			for (int i = 0; i < books.getLength(); i++) {
				System.out.println("开始解析第" + (i + 1) + "本书");
				this.book = new Book();
				Node book = books.item(i);
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					if (attrs.item(j).getNodeName() == "id") {
						System.out.println("id=" + attrs.item(j).getNodeValue());
						this.book.setId(attrs.item(j).getNodeValue());
					}
				}
				NodeList childnodes = book.getChildNodes();
				for (int j = 0; j < childnodes.getLength(); j++) {
					if (childnodes.item(j).getNodeName().trim() != "") {
						Node childnode = childnodes.item(j);
						String title = childnode.getNodeName();
						switch (title) {
						case "name":
							this.book.setName(childnode.getFirstChild().getNodeValue());
							break;
						case "author":
							this.book.setAuthor(childnode.getTextContent());
							break;
						case "year":
							this.book.setYear(childnode.getTextContent());
							break;
						case "price":
							this.book.setPrice(childnode.getTextContent());
							break;
						case "language":
							this.book.setLanguage(childnode.getTextContent());
							break;

						}

					}
				}
				booklist.add(this.book);
				System.out.println(this.book);
				System.out.println("已解析完第" + (i + 1) + "本书");
				System.out.println();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> getBooklist() {
		return booklist;
	}

}
