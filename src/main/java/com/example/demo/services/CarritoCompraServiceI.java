package com.example.demo.services;

import java.util.List;

import com.exameple.demo.model.Articulo;

public interface CarritoCompraServiceI {

	// metodos taller 1
	
	
	public void limpiarCesta();
	
	
	
	public void addArticulo(Articulo articulo);
	
	
	public Integer getNumArticulos();
	
	
	public List<Articulo> getArticulos();
	
	
	public Double totalPrice();
	
	
	public Double calculadorDescuento(Double precio, Double porcentaje);
	
	//quedan declarados en la interfaz todos los métodos que había que implementar.
	
	//definimos el metodo taller 2
	public Double aplicarDescuento(Integer iDArticulo, Double porcentaje);
	
	
	//métodos taller final
	public Integer InsertarArticulo (Articulo articulo); //Añadir articulo a la BBDD
	
	
	public Articulo getArticulo(Integer identificador); //Añadir articulo a la cesta
	
	


	
}
