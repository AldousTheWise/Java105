package modelo;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    protected Vendedor vendedor;
    protected List<Producto> productos;
    protected int totalGanancia;
    
 public Venta(Vendedor vendedor) {
	 this.vendedor = vendedor;
	 this.productos = new ArrayList<>();
	 this.totalGanancia = 0;	 
 }   
 
 public void agregarProducto(Producto producto) {
	 if (productos.size() < 10) {
		 productos.add(producto);
		 producto.venderProducto();
		 totalGanancia += producto.getPrecio();
	 } else {
		 System.out.println("Carro Lleno. (Max. 10 productos)");
	 }
 } 


 public void eliminarProducto(String codigo) {
    Producto productoAEliminar = null;
      
    for (Producto producto : productos) {
	   if(producto.getCodigo().equals(codigo)) {
		  productoAEliminar = producto;
		  break;
		}
    }
         
    if (productoAEliminar != null) {
        productos.remove(productoAEliminar);
        totalGanancia -= productoAEliminar.getPrecio();
         System.out.println("Producto eliminado del carro: " + productoAEliminar);
    } else {
        System.out.println("Producto no encontrado");
    }
  }
 
 public void listarProductosCarro() {
	 if (productos.isEmpty()) {
		System.out.println("El Carro de compras está vacío.");
	} else {
          for (Producto producto : productos) {
        	  System.out.println(producto.toString());			
		}
	}
 }

  public int calcularTotal() {
	  return totalGanancia;
  }
  
  public void pagar() {
	  System.out.println("Total a pagar: $" + calcularTotal());
	  System.out.println("Vendedor :"+ vendedor.getNombre());
	  productos.clear();
  }
}


