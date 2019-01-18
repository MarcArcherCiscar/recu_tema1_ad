package parser_asignatura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Asignatura implements Serializable {

	private String nombre = null;
	private int hora = 0;
	private ArrayList<Profesor>profesores=null;
	

	public Asignatura() {
	}

	public Asignatura(String n, int e, ArrayList<Profesor> profesores) {
		this.nombre = n;
		this.hora = e;
	}

	public String getNombre() {
		return nombre;
	}

	public int getHora() {
		return hora;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void getHora(int e) {
		hora = e;
	}

	public void getProfesores() {
		Iterator it=profesores.iterator();
		while(it.hasNext()) {
			Profesor profesor=(Profesor) it.next();
			System.out.println("Nombre del profesor: "+profesor.getNombre()+" con o sin despacho: "+profesor.getDespacho());
		}
	}
	public void setOp(ArrayList<Profesor> op) {
		this.profesores = op;
	}
	public void print() {
		System.out.println("Nombre de la asignatura: " + nombre + " y horas de la asignatura: " + hora);
	}

}
