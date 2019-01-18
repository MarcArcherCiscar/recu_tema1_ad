package parser_asignatura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Asignatura> asignaturas = null;

	public Parser() {
		asignaturas = new ArrayList<Asignatura>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("asignatura");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				Asignatura p = getPersona(el);
				asignaturas.add(p);
			}
		}
	}
	
	private Asignatura getPersona(Element personaEle){
		
		String nombre = getTextValue(personaEle,"nombre");
		int edad = getIntValue(personaEle,"horas");
		Asignatura e = new Asignatura(nombre,edad, null);

		return e;		
		
	}
	
	/*private Profesor getProfesor(Element AccionEle){
		ArrayList<Profesor> Profearr=new ArrayList<Profesor>();
		String nombre_pro=AccionEle.getAttribute("asignaturas");
		NodeList nl = AccionEle.getElementsByTagName("asignatura");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				NodeList nl2 = AccionEle.getElementsByTagName("profesor");
				if (nl2 != null && nl2.getLength() > 0) {
					for (int x = 0; x < nl2.getLength(); x++) {
						Element el = (Element) nl2.item(x);
						String nombre=getTextValue(el,"nombre");
						String despacho=getTextValue(el,"despacho");
						Profesor pro=new Profesor(nombre, despacho);
						Profearr.add(pro);
					}
				}
			}
		}
		Profesor a=new Profesor(Profearr);
		return a;

	}*/
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){

		Iterator it = asignaturas.iterator();
		while(it.hasNext()) {
			Asignatura p=(Asignatura) it.next();
			p.print();
		}
	}
	
	

}
