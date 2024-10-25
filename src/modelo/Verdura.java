package modelo;

public class Verdura extends Producto{
	protected String fechaEnvasado, fechaCaducidad;

	public Verdura(String codigo, String nombre, int precio, String fechaEnvasado, String fechaCaducidad) {
		super(codigo, nombre, precio);
		this.fechaEnvasado = fechaEnvasado;
		this.fechaCaducidad = fechaCaducidad;
	}
    
	public String getFechaEnvasado() { return fechaEnvasado; }
	public String getFechaCaducidad() { return fechaCaducidad; }
	
	@Override
	public void listarProducto() {
		System.out.println(this.toString());	
	}

	@Override
	public void venderProducto() {
		System.out.println(this.getNombre() + " ha sido agregado al carrito.");
	}

	@Override
	public String getDetalles() {
		return "fecha de envasado = " + this.getFechaEnvasado() + ", fecha de vencimiento: " + this.getFechaCaducidad() + " .";
	}

}
