package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.*;

public class Main {
	
	private static void mostrarMenu() {
		System.out.println("Qué deseas hacer?");
		System.out.println("1. Mostrar productos disponibles.");
		System.out.println("2. Agregar productos al carro de compras.");
		System.out.println("3. Mostrar productos en el carro.");
		System.out.println("4. Eliminar productos.");
		System.out.println("5. Pagar.");
		System.out.println("0. Salir");
	}
	
	private static void listarProductos(List<Producto> productos) {
		System.out.println("Productos disponibles: ");
		for (Producto producto : productos) {
			producto.listarProducto();
		}
	}
	
	private static Producto buscarProductoPorCodigo(List<Producto> productos, String codigo) {
		for (Producto producto : productos) {
			if (producto.getCodigo().toUpperCase().equals(codigo)) {
				return producto;
			}
		}
		return null;
	}
	
	private static void agregarAlCarro(List<Producto> productos, Venta venta, Scanner sc) {
		System.out.println("Ingresa el código del producto a ingresar:");
		String codigo = sc.nextLine().toUpperCase();
		
		Producto productoSeleccionado = buscarProductoPorCodigo(productos, codigo);
		
		if(productoSeleccionado != null) {
			venta.agregarProducto(productoSeleccionado);
		} else {
			System.out.println("Producto no encontrado.");
		}	
	}
		
	private static void eliminarDelCarro(Venta venta, Scanner sc) {
		System.out.println("Ingresa el código del producto a eliminar:");
		String codigo = sc.nextLine().toUpperCase();
		venta.eliminarProducto(codigo);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Producto> productos = new ArrayList<>();
		
		productos.add(new Verdura("V001", "Papa nortina", 3000, "20-10-2024", "20-02-2025"));
		productos.add(new Verdura("V002", "Cebolla Morada", 2000, "22-09-2024", "20-12-2024"));
		productos.add(new Verdura("V003", "Limón jugoso", 1200, "15-09-2024", "20-11-2024"));
		productos.add(new Verdura("V004", "Frutilla", 3500, "17-09-2024", "27-11-2024"));
		productos.add(new Vestuario("R001", "Shorts Cargo", 9990, "XL", "azul marino"));
		productos.add(new Vestuario("R002", "Blusa formal", 5590, "M", "beige"));
		productos.add(new Vestuario("R003", "Falda veraniega", 7990, "M", "amarillo"));
		productos.add(new Vestuario("R004", "Jeans Regular", 12990, "L", "negro"));
		
		
		String nombre = "";
		String rut = "";
		System.out.println("Hola!");
		System.out.println("Ingresa tus datos para comenzar: ");
		
		while(nombre.isEmpty()) {
		     System.out.println("Nombre: ");
		     nombre = sc.nextLine();
		     if (nombre.isEmpty()) {
		   	    System.out.println("El nombre no puede estar vacío.");  
		     }
		}
		
		while (rut.isEmpty()) {
			System.out.println("Rut:");
			rut = sc.nextLine();
			if(rut.isEmpty()) {
				System.out.println("El rut no puede estar vacío.");
			}
		}
	
		
		Vendedor vendedor = new Vendedor(nombre, rut);
		Venta venta = new Venta(vendedor);	
	    boolean salir = false;
	    
	    while(!salir) {
	    	mostrarMenu();
	    	int opcion = sc.nextInt();
	    	sc.nextLine();
	    	
	    	switch (opcion) {
			  case 1:
		         listarProductos(productos);
			  break;
              case 2:
				 agregarAlCarro(productos, venta, sc); 
			  break;
              case 3:
	             venta.listarProductosCarro();
	          break;
              case 4:
            	  eliminarDelCarro(venta, sc);      
	          break;
              case 5:
            	  venta.pagar();
              break;
              case 0:
	              salir = true;
	              System.out.println("Hasta luego.");
	          break;
			  default:
			  System.out.println("Ingrese una opción válida.");	
			  break;
			}
	    }
					
		
       sc.close();
	}

}
