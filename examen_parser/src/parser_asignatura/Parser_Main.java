package parser_asignatura;

public class Parser_Main {

	public static void main(String[] args) {
				
		Parser parser=new Parser();
		parser.parseFicheroXml("asignaturas.xml");
		parser.parseDocument();
		parser.print();

	}

}
