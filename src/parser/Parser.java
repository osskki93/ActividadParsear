package parser;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Parser {
	
	private Document dom = null;
	private ArrayList <Libro> libros = null;

	
	public Parser () {
		libros = new ArrayList<Libro>();
	}
	
	
	public void parseFicheroXML (String fichero) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
	
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void parseDocument() {
		
		Element docEle = dom.getDocumentElement();
		NodeList n1 = docEle.getElementsByTagName("libro");
		
		if (n1 != null && n1.getLength() > 0) {
			for (int i = 0; i < n1.getLength() ; i++) {
				
				Element el = (Element) n1.item(i);
				Libro l = getLibro(el);
				libros.add(l);
				
				
			}
		}
	
	}
	
	private Libro getLibro (Element libroEle) {
		
		String titulo = getTextValue(libroEle, "titulo");
		int anyo = getIntAtribute (libroEle, "titulo");
		ArrayList <String> autores= getArray (libroEle, "autor");
		String editor = getTextValue(libroEle, "editor");
		int paginas = getIntValue(libroEle, "paginas");
		
		Libro l = new Libro (titulo, anyo, autores, editor, paginas);
		return l;

	}
	
	private String getTextValue (Element ele, String tagName) {
		
		String textValue = null;
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			textValue = el.getFirstChild().getTextContent();
		}
		
		return textValue;
	}
	
	private int getIntValue (Element ele, String tagName) {
		
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	private int getIntAtribute (Element ele, String tagName) {
		
		int anyo = 0;
		NodeList n1 = ele.getElementsByTagName(tagName);
		if (n1 != null && n1.getLength() > 0) {
			Element el = (Element) n1.item(0);
			anyo = Integer.parseInt(el.getAttribute("anyo"));
		}
		
		return anyo;

	}
	
	private ArrayList<String> getArray (Element ele, String tagName) {
		
		ArrayList <String> autores = new ArrayList<String>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlNombres = el.getElementsByTagName("nombre");
			if (nlNombres != null && nlNombres.getLength() > 0) {
				for (int i = 0; i < nlNombres.getLength() ; i++) {
					Element e1 = (Element) nlNombres.item(i);
					autores.add(e1.getFirstChild().getTextContent());
			}
			
		}
		
	}
		
		return autores;
	}
	
	public void print () {
		
		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			System.out.println(l);
			
		}
	}
	
}
