package modelo;


public class Vestuario extends Producto{
	protected String talla, color;

	public Vestuario(String codigo, String nombre, int precio, String talla, String color) {
		super(codigo, nombre, precio);
		this.talla = talla;
		this.color = color;
	}
	
	public String getTalla() { return talla; }
	public String getColor() { return color; }

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
		return "talla = " + this.getTalla() + ", color = " + this.getColor() + " .";
	}


}
