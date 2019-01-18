package parser_asignatura;

import java.util.ArrayList;

public class Profesor {
	
	private String nombre=null;
	private String despacho= null;
	

	
	public Profesor(String nombreProfe, String cantidad) {
		this.nombre=nombreProfe;
		this.despacho=cantidad;
	}

	public Profesor(ArrayList<Profesor> profearr) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

}
