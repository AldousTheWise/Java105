package modelo;

public class Vendedor {
	private String nombre, rut;
	
	public Vendedor(String nombre, String rut) {
		this.nombre = nombre;
     	this.rut = rut;
	}
	
	public String getNombre() { return nombre; }
	public String getRut() { return rut; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setRut(String rut) { this.rut = rut; }
	
	
	public String toString() {
		return "Vendedor = " + this.getNombre() + " .";
	}
}
