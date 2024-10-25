package modelo;

import interfaz.IAcciones;

public abstract class Producto implements IAcciones{
     protected int precio;
     protected String nombre, codigo;
     
     public Producto(String codigo, String nombre, int precio) {
    	 this.codigo = codigo;
    	 this.nombre = nombre;
    	 this.precio = precio;
     } 
     
     
     public String getCodigo() { return codigo;}
     public String getNombre() { return nombre; }
     public int getPrecio() { return precio; }
     
     public void setCodigo( String codigo ) { this.codigo = codigo; }
     public void setNombre( String nombre ) { this.nombre = nombre; }
     public void setPrecio( int precio ) { this.precio = precio; }
     
     
     public abstract String getDetalles();
     
     @Override
     public String toString() {
    	 return "Producto = " + this.getNombre() + ". codigo = " + this.getCodigo() + ", precio = " + this.getPrecio() + ", " + this.getDetalles();
     }
     
     @Override
     public abstract void listarProducto();

     @Override
     public abstract void venderProducto();
}
